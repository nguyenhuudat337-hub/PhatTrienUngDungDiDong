package com.example.bai243;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<QuanLyCV> list;

    public MyAdapter(List<QuanLyCV> list){
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textWork, textContent,textDate,textTime;
        public MyViewHolder(View itemView){
            super(itemView);
            textWork = itemView.findViewById(R.id.textView10);
            textContent = itemView.findViewById(R.id.textView11);
            textDate = itemView.findViewById(R.id.textView12);
            textTime = itemView.findViewById(R.id.textView13);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_work,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        QuanLyCV cv = list.get(position);
        holder.textWork.setText(cv.getCongViec());
        holder.textContent.setText(cv.getNoiDung());
        holder.textDate.setText(cv.getNgayHT());
        holder.textTime.setText(cv.getGioHT());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
