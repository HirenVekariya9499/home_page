package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HolderFavourite extends RecyclerView.ViewHolder {

    TextView storename;

    public HolderFavourite(View itemView) {
        super(itemView);

        storename= (TextView) itemView.findViewById(R.id.favouritestores);
    }
}
