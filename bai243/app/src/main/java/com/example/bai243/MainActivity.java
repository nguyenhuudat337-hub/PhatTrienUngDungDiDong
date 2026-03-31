package com.example.bai243;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

    EditText textCongViec, textNoiDung, textNgayHT, textGioHT;
    Button btnThemCV;
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

        textCongViec = findViewById(R.id.editTextText);
        textNoiDung = findViewById(R.id.editTextText1);
        textNgayHT = findViewById(R.id.editTextDate);
        textGioHT = findViewById(R.id.editTextTime);
        btnThemCV = findViewById(R.id.button3);


        List<QuanLyCV> list = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);

        btnThemCV.setOnClickListener(v -> {
            String cv = textCongViec.getText().toString();
            String nd = textNoiDung.getText().toString();
            String ngay = textNgayHT.getText().toString();
            String gio = textGioHT.getText().toString();

            list.add(new QuanLyCV(cv,nd,ngay,gio));
            adapter.notifyDataSetChanged();

        });
    }
}