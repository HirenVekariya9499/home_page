package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyHolderShops extends RecyclerView.ViewHolder {

    TextView storename,location,status;
    ImageView imageurl;

    public MyHolderShops(View itemView) {
        super(itemView);

        imageurl= (ImageView) itemView.findViewById(R.id.imageView1);
        storename= (TextView) itemView.findViewById(R.id.storename1);
        location= (TextView) itemView.findViewById(R.id.location);
        status= (TextView) itemView.findViewById(R.id.status);

    }
}
