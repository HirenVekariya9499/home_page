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

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

     List<homeRetro> HomeRetro;
     View view;



    public MyAdapter(List<homeRetro> HomeRetro,View view) {
        this.HomeRetro =HomeRetro;
        this.view=view;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item__home_recommendation,parent,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.itemname.setText(HomeRetro.get(position).getItemname());
        holder.storename.setText(HomeRetro.get(position).getStorename());


        Glide.with(view)
                .load(HomeRetro.get(position).getImageurl())
                .into(holder.imageurl);
    }

    @Override
    public int getItemCount() {
        return HomeRetro.size();
    }
}
