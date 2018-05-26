package com.example.samcom.homepage;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class HolderFavourite1 extends RecyclerView.ViewHolder {

    TextView itemname,price;

    public HolderFavourite1(View itemView) {
        super(itemView);

        itemname= (TextView) itemView.findViewById(R.id.itemnamef);
        price= (TextView) itemView.findViewById(R.id.pricef);

    }
}

