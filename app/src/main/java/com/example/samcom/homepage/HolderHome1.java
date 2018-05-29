package com.example.samcom.homepage;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HolderHome1 extends RecyclerView.ViewHolder {

    TextView storename, location, status;
    ImageView imageurl;
    RelativeLayout card;
    private FragmentManager fragmentManager;

    public HolderHome1(View itemView) {
        super( itemView );

        imageurl = (ImageView) itemView.findViewById( R.id.imageView1 );
        storename = (TextView) itemView.findViewById( R.id.storename1 );
        location = (TextView) itemView.findViewById( R.id.location );
        card = itemView.findViewById( R.id.card );


    }
//
//    @Override
//    public void onClick(View v) {
//        FragmentFavourite home = new FragmentFavourite();
////                Bundle bundle=new Bundle();
////                bundle.putString("id", String.valueOf( HomeRetro1.get( getId()) ) );
////                setArguments( bundle );
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace( R.id.hn, home, home.getTag() ).commit();
//    }
//
//    public FragmentManager getFragmentManager() {
//        return fragmentManager;
//    }
}
