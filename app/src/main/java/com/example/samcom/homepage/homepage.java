package com.example.samcom.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    FragmentHome home=new FragmentHome();
                    FragmentManager managerHome;
                {
                    managerHome = getSupportFragmentManager();
                    managerHome.beginTransaction().replace(R.id.hn,home,home.getTag()).addToBackStack( null ).commit();
                }

//                mTextMessage.setText( R.string.title_home );
                    return true;
                case R.id.navigation_favourite:

                    FragmentFavourite favourite=new FragmentFavourite();
                    FragmentManager managerFavourite;
                {
                    managerFavourite = getSupportFragmentManager();
                    managerFavourite.beginTransaction().replace(R.id.hn,favourite,favourite.getTag()).addToBackStack(null).commit();
                }
//                    mTextMessage.setText( R.string.title_favourite );
                    return true;
                case R.id.navigation_cart:

                    FragmentCart cart=new FragmentCart();
                    FragmentManager managerCart;
                {
                    managerCart = getSupportFragmentManager();
                    managerCart.beginTransaction().replace(R.id.hn,cart,cart.getTag()).addToBackStack( null ).commit();
                }

//                    mTextMessage.setText( R.string.title_cart );
                    return true;
                case R.id.navigation_notifications:

                    FragmentNotification notification=new FragmentNotification();
                    FragmentManager managerNotification;
                {
                    managerNotification = getSupportFragmentManager();
                    managerNotification.beginTransaction().replace(R.id.hn,notification,notification.getTag()).addToBackStack( null ).commit();
                }


//                mTextMessage.setText( R.string.title_notifications );
                    return true;
                case R.id.navigation_profile:

                    FragmentUserProfile userprofile=new FragmentUserProfile();
                    FragmentManager managerUserprofile;
                {
                    managerUserprofile = getSupportFragmentManager();
                    managerUserprofile.beginTransaction().replace(R.id.hn,userprofile,userprofile.getTag()).addToBackStack( null ).commit();
                }


//                mTextMessage.setText( R.string.title_Profile );
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_homepage );

        FragmentHome home=new FragmentHome();
        FragmentManager managerHome;
        {
            managerHome = getSupportFragmentManager();
            managerHome.beginTransaction().replace(R.id.hn,home,home.getTag()).commit();
        }


//        mTextMessage = (TextView) findViewById( R.id.message );
        BottomNavigationView navigation = (BottomNavigationView) findViewById( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );
    }

}
