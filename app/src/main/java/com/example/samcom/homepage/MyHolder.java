package com.example.samcom.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView nametxt;

    public MyHolder(View itemView) {
        super(itemView);

        nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
    }
}
