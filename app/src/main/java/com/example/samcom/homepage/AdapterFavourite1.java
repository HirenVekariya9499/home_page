package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterFavourite1 extends RecyclerView.Adapter<HolderFavourite1> {

    List<RetroFavourite1> FavouriteRetro1;

    public AdapterFavourite1(List<RetroFavourite1> FavouriteRetro1) {
        this.FavouriteRetro1=FavouriteRetro1;
    }

    @Override
    public HolderFavourite1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_favourite_items,parent,false);

        return new HolderFavourite1(v);
    }

    @Override
    public void onBindViewHolder(HolderFavourite1 holder, int position) {
        holder.itemname.setText(FavouriteRetro1.get(position).getItemname());
        holder.price.setText(FavouriteRetro1.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return FavouriteRetro1.size();
    }
}
