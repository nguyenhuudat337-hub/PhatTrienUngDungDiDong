package com.example.bai242;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtMaSp,edtTenSp,edtGia;
    Button btnNhap,btnXoa,btnSua;

    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMaSp = findViewById(R.id.editTextText);
        edtTenSp = findViewById(R.id.editTextText2);
        edtGia = findViewById(R.id.editTextText3);
        btnNhap = findViewById(R.id.button);
        btnXoa = findViewById(R.id.button2);
        checkBox = findViewById(R.id.checkBox);
        btnSua = findViewById(R.id.button3);


        RecyclerView recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        List<Item> list = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(list, allChecked -> {
            checkBox.setChecked(allChecked);
        });
        recyclerview.setAdapter(adapter);

        if (list.isEmpty()) {
            checkBox.setChecked(false);
            checkBox.setEnabled(false);
        }

        btnNhap.setOnClickListener(v -> {
            String masp = edtMaSp.getText().toString().trim();
            String tensp = edtTenSp.getText().toString().trim();
            String gia = edtGia.getText().toString().trim();
            if (masp.isEmpty() || tensp.isEmpty() || gia.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                checkBox.setEnabled(true);
                for (Item item : list) {
                    if(item.getMasp().equals(masp) || item.getTensp().equals(tensp)){
                        Toast.makeText(MainActivity.this, "Sản phẩm đã tồn tại", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Item item = new Item(masp, tensp, gia);
                list.add(item);
                adapter.notifyDataSetChanged();
                edtMaSp.setText("");
                edtTenSp.setText("");
                edtGia.setText("");
                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });


        btnXoa.setOnClickListener(v -> {
            for(int i = list.size()-1 ; i >= 0 ; i--){
                if(list.get(i).ischecked()) {
                    list.remove(i);
                    Toast.makeText(MainActivity.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                }
            }
            if (list.isEmpty()) {
                checkBox.setChecked(false);
                checkBox.setEnabled(false);
            }
            adapter.notifyDataSetChanged();
        });

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            for (Item item : list) {
                item.setchecked(isChecked);
            }
            adapter.notifyDataSetChanged();
        });

        btnSua.setOnClickListener(v -> {
            String masp = edtMaSp.getText().toString().trim();
            String tensp = edtTenSp.getText().toString().trim();
            String gia = edtGia.getText().toString().trim();
            if (masp.isEmpty() || tensp.isEmpty() || gia.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            for (Item item : list) {
                if(item.getMasp().equals(masp)){
                    item.setTensp(tensp);
                    item.setGia(gia);
                    Toast.makeText(MainActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    edtMaSp.setText("");
                    edtTenSp.setText("");
                    edtGia.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
            Toast.makeText(MainActivity.this, "Sản phẩm không tồn tại", Toast.LENGTH_SHORT).show();
        });


    }
}