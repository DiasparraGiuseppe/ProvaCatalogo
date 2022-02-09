package com.example.provacatalogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Integer> pic;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);


        // titles = new ArrayList<>();
        pic = new ArrayList<>();


        adapter = new Adapter(this, pic);

        pic.add(R.drawable.nigiri);
        pic.add(R.drawable.nigiri);
        pic.add(R.drawable.nigiri);
        pic.add(R.drawable.nigiri);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2 , LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}