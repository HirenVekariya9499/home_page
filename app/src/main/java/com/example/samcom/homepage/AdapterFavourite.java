package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterFavourite extends RecyclerView.Adapter<HolderFavourite> {

    List<RetroFavourite> FavouriteRetro;


    public AdapterFavourite(List<RetroFavourite> FavouriteRetro) {
        this.FavouriteRetro=FavouriteRetro;
    }

    @Override
    public HolderFavourite onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_favourite_stores,parent,false);

        return new HolderFavourite(v);
    }

    @Override
    public void onBindViewHolder(HolderFavourite holder, int position) {
        holder.storename.setText(FavouriteRetro.get(position).getStorename());

    }

    @Override
    public int getItemCount() {
        return FavouriteRetro.size();
    }
}
