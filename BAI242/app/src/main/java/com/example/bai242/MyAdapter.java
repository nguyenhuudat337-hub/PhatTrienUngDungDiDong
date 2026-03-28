package com.example.bai242;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Item> list;


    private OnAllCheckedChangedListener listener;
    public interface OnAllCheckedChangedListener {
        void onAllCheckedChanged(boolean allChecked);
    }
    public MyAdapter(List<Item> list, OnAllCheckedChangedListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textMaSp,textTenSp,textGia;
        CheckBox btnCheck;

        public MyViewHolder(View v) {
            super(v);
            textMaSp = itemView.findViewById(R.id.masp);
            textTenSp = itemView.findViewById(R.id.tensp);
            textGia = itemView.findViewById(R.id.gia);
            btnCheck = itemView.findViewById(R.id.checkBox2);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = list.get(position);
        holder.textMaSp.setText(item.getMasp());
        holder.textTenSp.setText(item.getTensp());
        holder.textGia.setText(item.getGia());
        holder.btnCheck.setChecked(item.ischecked());

        holder.btnCheck.setOnCheckedChangeListener(null);

        holder.btnCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setchecked(isChecked);
            boolean allChecked = true;
            for(Item i :list){
                if(!i.ischecked()){
                    allChecked = false;
                    break;
                }
            }
            listener.onAllCheckedChanged(allChecked);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();

    }
}