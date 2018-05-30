package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterHome1 extends RecyclerView.Adapter<HolderHome1> {

    private List<RetroHome1> HomeRetro1;
    View view;

    public AdapterHome1(List<RetroHome1> HomeRetro1, View view)
    {
        this.HomeRetro1 =HomeRetro1;
        this.view=view;
    }

    @Override
    public HolderHome1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_home_shops,parent,false);

        return new HolderHome1(v);
    }

    @Override
    public void onBindViewHolder(HolderHome1 holder, int position) {

        Glide.with(view)
                .load(HomeRetro1.get(position).getImageurl())
                .into(holder.imageurl);


        holder.storename.setText(HomeRetro1.get(position).getStorename());
        holder.location.setText(HomeRetro1.get(position).getLocation());
//        holder.status.setText(HomeRetro1.get(position).getStatus());


    }

    @Override
    public int getItemCount() {
        return HomeRetro1.size();
    }
}
