package com.example.samcom.homepage;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class favouriteAdapter extends RecyclerView.Adapter<favouriteHolder> {

    List<favouriteRetro> FavouriteRetro;

    public favouriteAdapter(List<favouriteRetro> FavouriteRetro) {
        this.FavouriteRetro=FavouriteRetro;
    }

    @Override
    public favouriteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_favourite_stores,parent,false);

        return new favouriteHolder(v);
    }

    @Override
    public void onBindViewHolder(favouriteHolder holder, int position) {
        holder.storename.setText(FavouriteRetro.get(position).getStorename());

    }

    @Override
    public int getItemCount() {
        return FavouriteRetro.size();
    }
}
