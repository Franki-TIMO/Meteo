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


    public static class ItemViewHolder extends RecyclerView.ViewHolder {



        public ItemViewHolder(@NonNull View itemView) {

        }
    }

    public ItemsAdapter(ArrayList<ItemsGenerate> itemList) {


    }




}


