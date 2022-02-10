package com.example.provacatalogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = null;
    private RecyclerView recyclerView;
    private List<ImageView> pic;
   // private List<String> titles;
    private Adapter adapter;
    ImageView imageView;

   /* FirebaseRecyclerOptions<Category> options_cat;
    FirebaseRecyclerAdapter<Category, ViewHolderCategory> adapter_cat;*/
    DatabaseReference dataref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        dataref= FirebaseDatabase.getInstance().getReference().child("categoriesprova");
         //titles = new ArrayList<>();
        pic = new ArrayList<ImageView>();
        adapter = new Adapter(this, pic);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Metti nome ristorante");
        actionBar.setDisplayHomeAsUpEnabled(true);


        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                  for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String link =snapshot.getValue(String.class);
                    Picasso.get().load(link).into(imageView);
                    pic.add(imageView);

                    //titles.add(snapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

            //loadData("");

       /* pic.add(R.drawable.nigiri);
        pic.add(R.drawable.nigiri);
        pic.add(R.drawable.nigiri);
        pic.add(R.drawable.nigiri);*/

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2 , LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }

}
