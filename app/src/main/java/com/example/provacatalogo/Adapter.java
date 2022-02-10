package com.example.provacatalogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private Context context;
    //private List<String> titles;
    private List<ImageView> pic;

    public  Adapter(Context context, List<ImageView> pic){
        this.context =context;
        this.pic = pic;
      // this.titles=titles;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return  new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //holder.textView.setText(titles.get(position));
        //holder.imageView.setImageResource(pic.get(position));
        holder.imageView=pic.get(position);
                /*pic.get(position);*/
    }

    @Override
    public int getItemCount() {
        return pic.size();
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