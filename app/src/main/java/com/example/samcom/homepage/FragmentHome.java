package com.example.samcom.homepage;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentHome extends Fragment {

    private List<RetroHome> HomeRetro;
    private AdapterHome adapter;
    private List<RetroHome1> HomeRetro1;
    private AdapterHome1 adapter1;
    RelativeLayout card;
//    CardView cardView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate( R.layout.fragment_home, container, false );

        final RecyclerView rv = (RecyclerView) rootView.findViewById( R.id.firstrv );
        rv.setLayoutManager( new LinearLayoutManager( this.getActivity(), LinearLayoutManager.HORIZONTAL, false ) );
        rv.setNestedScrollingEnabled( false );


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( API.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create( API.class );

        Call<List<RetroHome>> call = api.getRecommendation();

        call.enqueue( new Callback<List<RetroHome>>() {
            @Override
            public void onResponse(Call<List<RetroHome>> call, Response<List<RetroHome>> response) {

                List<RetroHome> homeRetros = response.body();

                HomeRetro = response.body();
//                Context context = null;
                adapter = new AdapterHome( HomeRetro, rootView );
                rv.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<RetroHome>> call, Throwable t) {

            }
        } );


        final RecyclerView rv1 = (RecyclerView) rootView.findViewById( R.id.secondrv );
        rv1.setLayoutManager( new LinearLayoutManager( this.getActivity() ) );
        rv1.setNestedScrollingEnabled( false );


//        card = card.findViewById( R.id.card );
//        card.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FragmentFavourite home = new FragmentFavourite();
////                Bundle bundle=new Bundle();
////                bundle.putString("id", String.valueOf( HomeRetro1.get( getId()) ) );
////                setArguments( bundle );
//                FragmentManager manager = getFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                transaction.replace( R.id.hn, home, home.getTag() ).commit();
//
//            }
//        } );


        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl( API.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api1 = retrofit1.create( API.class );

        Call<List<RetroHome1>> call1 = api1.getRecommendation1();

        call1.enqueue( new Callback<List<RetroHome1>>() {
            @Override
            public void onResponse(Call<List<RetroHome1>> call1, Response<List<RetroHome1>> response) {

                List<RetroHome1> homeRetros1 = response.body();

                //sending parameters
                int userid = response.body().get( 0 ).getId();
                Log.e( "TAG", "senderid :" + userid );

                FragmentFavourite second=new FragmentFavourite();
                Bundle bundle=new Bundle();
                bundle.putString("name","India" );
                second.setArguments(bundle);
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().commit();
                //

                HomeRetro1 = response.body();
                adapter1 = new AdapterHome1( HomeRetro1, rootView );
                rv1.setAdapter( adapter1 );
            }

            @Override
            public void onFailure(Call<List<RetroHome1>> call1, Throwable t) {

            }
        } );

        return rootView;

    }
}
