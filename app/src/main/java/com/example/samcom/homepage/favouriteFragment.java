package com.example.samcom.homepage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class favouriteFragment extends Fragment {


    private List<favouriteRetro> FavouriteRetro;
    private favouriteAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView=inflater.inflate(R.layout.fragment_favourite,container,false);

        final RecyclerView rv= (RecyclerView) rootView.findViewById(R.id.firstrvr);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rv.setNestedScrollingEnabled(false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( homeRetroAPI.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        homeRetroAPI api = retrofit.create( homeRetroAPI.class );

        Call<List<favouriteRetro>> call = api.getRecommendation2();

        call.enqueue( new Callback<List<favouriteRetro>>() {
            @Override
            public void onResponse(Call<List<favouriteRetro>> call, Response<List<favouriteRetro>> response) {

                List<favouriteRetro> favouriteRetros= response.body();

                FavouriteRetro=response.body();
                adapter=new favouriteAdapter( FavouriteRetro);
                rv.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<favouriteRetro>> call, Throwable t) {

            }
        } );




        return rootView;
    }

}
