package com.example.samcom.homepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapterShops extends RecyclerView.Adapter<MyHolderShops> {

    Context c;
    String[] movies;

    public MyAdapterShops(Context c, String[] movies) {
        this.c = c;
        this.movies = movies;
    }

    @Override
    public MyHolderShops onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_home_shops,parent,false);

        return new MyHolderShops(v);
    }

    @Override
    public void onBindViewHolder(MyHolderShops holder, int position) {
        holder.nametxt.setText(movies[position]);

    }

    @Override
    public int getItemCount() {
        return movies.length;
    }
}
