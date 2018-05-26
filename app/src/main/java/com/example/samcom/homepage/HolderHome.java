package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HolderHome extends RecyclerView.ViewHolder {

    TextView itemname,storename;
    ImageView imageurl;
    public HolderHome(View itemView) {
        super(itemView);

        imageurl= (ImageView) itemView.findViewById(R.id.imageView);
        itemname= (TextView) itemView.findViewById(R.id.itemname);
        storename= (TextView) itemView.findViewById(R.id.storename);


    }
}
