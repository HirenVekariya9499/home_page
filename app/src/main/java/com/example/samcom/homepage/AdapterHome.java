package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<HolderHome> {

     List<RetroHome> HomeRetro;
     View view;



    public AdapterHome(List<RetroHome> HomeRetro, View view) {
        this.HomeRetro =HomeRetro;
        this.view=view;
    }

    @Override
    public HolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item__home_recommendation,parent,false);

        return new HolderHome(v);
    }

    @Override
    public void onBindViewHolder(HolderHome holder, int position) {
        holder.itemname.setText(HomeRetro.get(position).getItemname());
        holder.storename.setText(HomeRetro.get(position).getStorename());
        holder.price.setText(HomeRetro.get(position).getPrice());


        Glide.with(view)
                .load(HomeRetro.get(position).getImageurl())
                .into(holder.imageurl);
    }

    @Override
    public int getItemCount() {
        return HomeRetro.size();
    }
}
