package com.example.provacatalogo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private Context context;
    //private List<String> titles;
    private List<String> categories;

    public  Adapter(Context context, List<String> categories){
        this.context =context;
        this.categories = categories;
      // this.titles=titles;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return  new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //holder.textView.setText(titles.get(position));
        //holder.imageView.setImageResource(pic.get(position));
        //holder.imageView=pic.get(position);

        Picasso.get().load(categories.get(position)).into(holder.imageView);
         holder.imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent =new Intent(context,CategoryActivity.class);
                 intent.putExtra("CategoryKey",Integer.valueOf(position));       //ricordati di fare get extra
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return categories.size();
        //return titles.size();
    }

    public  static  class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
           // textView = itemView.findViewById(R.id.textView);
        }
    }
}