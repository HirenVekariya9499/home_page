package com.example.samcom.homepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapterShops extends RecyclerView.Adapter<MyHolderShops> {

    private List<homeRetro1> HomeRetro1;
    View view;

    public MyAdapterShops(List<homeRetro1> HomeRetro1,View view)
    {
        this.HomeRetro1 =HomeRetro1;
        this.view=view;
    }

    @Override
    public MyHolderShops onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_home_shops,parent,false);

        return new MyHolderShops(v);
    }

    @Override
    public void onBindViewHolder(MyHolderShops holder, int position) {

        Glide.with(view)
                .load(HomeRetro1.get(position).getImageurl())
                .into(holder.imageurl);


        holder.storename.setText(HomeRetro1.get(position).getStorename());
        holder.location.setText(HomeRetro1.get(position).getLocation());
        holder.status.setText(HomeRetro1.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return HomeRetro1.size();
    }
}
