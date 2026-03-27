package com.example.bai242;

import android.os.Bundle;
import android.widget.Button;
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
    Button btnNhap;
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


        RecyclerView recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        List<Item> list = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(list);
        recyclerview.setAdapter(adapter);
        btnNhap.setOnClickListener(v -> {
            String masp = edtMaSp.getText().toString().trim();
            String tensp = edtTenSp.getText().toString().trim();
            String gia = edtGia.getText().toString().trim();
            if (masp.isEmpty() || tensp.isEmpty() || gia.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Item item = new Item(masp, tensp, gia);
                list.add(item);
                adapter.notifyDataSetChanged();
                edtMaSp.setText("");
                edtTenSp.setText("");
                edtGia.setText("");
                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }

        });
    }
}