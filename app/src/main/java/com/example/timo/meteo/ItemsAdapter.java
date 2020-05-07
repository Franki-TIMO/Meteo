package com.example.timo.meteo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import static androidx.core.content.ContextCompat.startActivity;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>  {
    private ArrayList<ItemsGenerate> mItemList;
    int couleur;
    Intent detail;
    private TextView textView;
    public static  Meteo m;


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView ville;
        public ImageView image;
        public TextView temperature;
        public TextView heure;



        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ville = itemView.findViewById(R.id.itemVille);
            image = itemView.findViewById(R.id.itemImage);
            temperature = itemView.findViewById(R.id.itemTemperature);
            heure = itemView.findViewById(R.id.itemHeure);
        }
    }

    public ItemsAdapter(ArrayList<ItemsGenerate> itemList) {

        mItemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        //layoutCard.findViewById(R.id.layoutCard);
        //layoutCard.setBackground(layoutCard.getResources().getDrawable(R.drawable.card_shape));
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
        detail = new Intent(parent.getContext(),DetailsActivity.class);


        couleur++;
        switch (couleur % 4) {
            case 0:
                view.findViewById(R.id.layoutCard).setBackground(view.getResources().getDrawable(R.drawable.card_shape2));
                break;
            case 1:
                view.findViewById(R.id.layoutCard).setBackground(view.getResources().getDrawable(R.drawable.card_shape));
                break;
            case 2:
                view.findViewById(R.id.layoutCard).setBackground(view.getResources().getDrawable(R.drawable.card_shape3));
                break;
            case 3:
                view.findViewById(R.id.layoutCard).setBackground(view.getResources().getDrawable(R.drawable.card_shape1));
                break;
        }



        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

        m = MainActivity.meteo.get(position);

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
        String date = sdf.format(new Date());
        ItemsGenerate currentItem = mItemList.get(position);
        holder.heure.setText(date);
        holder.image.setImageResource(currentItem.getImage());
        holder.temperature.setText(currentItem.getTemperature());
        holder.ville.setText(currentItem.getVille());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.CONTEXT, DetailsActivity.class);
                m = MainActivity.meteo.get(position);

                startActivity(MainActivity.CONTEXT,detail,null);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

}


