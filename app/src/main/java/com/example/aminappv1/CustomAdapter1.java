package com.example.aminappv1;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList EventName;
    int EventImage[];
    //Construtor
    CustomAdapter1(Activity activity, Context context, ArrayList EventName, int EventImage[]){
        this.activity = activity;
        this.context = context;
        this.EventImage = EventImage;
        this.EventName = EventName;
    }

    @NonNull
    @Override //Este método cria o espaço no recycler view para guardar as informações
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Inflater = LayoutInflater.from(context);
        View view = Inflater.inflate(R.layout.events_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override//este metodo popula os respetivos campos com as respetivas informaçoes
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.EventName_Id.setText(String.valueOf(EventName.get(position)));
        holder.EventImage_Id.setImageResource(EventImage[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return EventName.size();
    }

    // este devolve os ids dos varios itens na cardview de modo ao adaptador saber onde popular com as informações
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView EventImage_Id;
        TextView EventName_Id;
        LinearLayout mainLayout;

        MyViewHolder (@NonNull View itemView){
            super(itemView);
            EventImage_Id = itemView.findViewById(R.id.Event_Image);
            EventName_Id = itemView.findViewById(R.id.Event_Name);
            mainLayout = itemView.findViewById(R.id.Event_Layout);
        }
    }
}
