package com.example.provacatalogo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.provacatalogo.model.Plate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView_plates;
    private List<String> platesName;
    private List<String> platesImg;
    private Adapter_Plates adapter_plates;
    ImageView imageView_plates;
    DatabaseReference dataref_plates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

       /* Intent intent = getIntent();
        String CategoryKey = intent.getStringExtra("CategoryKey");
        String nameConverted= convertToName(CategoryKey);*/

        recyclerView_plates = findViewById(R.id.recycleview_plates);
        dataref_plates= FirebaseDatabase.getInstance().getReference().child("catprova").child("GUNKAN");
        platesName= new ArrayList<String>();
        platesImg= new ArrayList<String>();
        adapter_plates = new Adapter_Plates(this,platesName,platesImg);

        ActionBar actionBar = getSupportActionBar();
       // actionBar.setTitle(nameConverted);
        actionBar.setDisplayHomeAsUpEnabled(true);


        dataref_plates.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int i=0;
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    if(i==2){
                        break;
                    }
                    i++;
                  // Plate plate = snapshot.getValue(Plate.class);


                    // FUNZIONA CON child("catprova").child("GUNKAN").child("G1"); e con dataSnapshot qua sotto


                    Plate plate = snapshot.getValue(Plate.class);
                    platesImg.add(plate.img);
                    platesName.add(plate.nome);
                }
                adapter_plates.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2 , LinearLayoutManager.VERTICAL, false);
        recyclerView_plates.setLayoutManager(gridLayoutManager);
        recyclerView_plates.setHasFixedSize(true);

        recyclerView_plates.setAdapter(adapter_plates);

    }

    private String convertToName(String categoryKey) {
        if(Integer.parseInt(categoryKey)==1){
            return "NIGIRI";
        }else return "GUNKAN";
    }




}
