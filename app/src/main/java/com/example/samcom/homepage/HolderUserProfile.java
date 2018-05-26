package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HolderUserProfile extends RecyclerView.ViewHolder {

    TextView uname,mnumber;
    public HolderUserProfile(View itemView) {
        super(itemView);

        uname= (TextView) itemView.findViewById(R.id.et1c);
        mnumber= (TextView) itemView.findViewById(R.id.et6c);


    }
}
