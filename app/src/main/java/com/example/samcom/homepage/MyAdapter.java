package com.example.samcom.homepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<homeRetro> HomeRetro;



    public MyAdapter(List<homeRetro> HomeRetro) {
        this.HomeRetro =HomeRetro;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item__home_recommendation,parent,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.uname.setText(HomeRetro.get(position).getUname());

    }

    @Override
    public int getItemCount() {
        return HomeRetro.size();
    }
}
