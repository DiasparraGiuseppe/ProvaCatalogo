package com.example.provacatalogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;


import androidx.appcompat.app.ActionBar;

import com.example.provacatalogo.model.Category;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> categories;
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
        dataref= FirebaseDatabase.getInstance().getReference().child("catprova");
         //titles = new ArrayList<>();
        categories = new ArrayList<String>();
        adapter = new Adapter(this, categories);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Metti nome ristorante");
        actionBar.setDisplayHomeAsUpEnabled(true);


        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                
                 for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                   // String link =snapshot.getValue(String.class);
                      Category cat= snapshot.getValue(Category.class);
                    //Picasso.get().load(link).into(imageView);
                   // pic.add(imageView);
                      categories.add(cat.img);
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
