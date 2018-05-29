package com.example.samcom.homepage;


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


public class FragmentFavourite extends Fragment {


    private List<RetroFavourite> FavouriteRetro;
    private AdapterFavourite adapter;
    private List<RetroFavourite1> FavouriteRetro1;
    private AdapterFavourite1 adapter1;
    RecyclerView rv,rv1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_favourite, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.firstrvr);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create(API.class);
        Bundle args = getArguments();
        int id = 0;
        if (args != null) {
            id = Integer.parseInt(args.getString("userid"));
        }
        Call<List<RetroFavourite>> call = api.getRecommendation2(id);

        call.enqueue(new Callback<List<RetroFavourite>>() {
            @Override
            public void onResponse(Call<List<RetroFavourite>> call, Response<List<RetroFavourite>> response) {

                List<RetroFavourite> favouriteRetros = response.body();

                FavouriteRetro = response.body();
                adapter = new AdapterFavourite(FavouriteRetro);
                rv.setAdapter(adapter);

//                adapter.setOnItemClickListener( (AdapterFavourite.OnItemClickListener) FragmentFavourite.this );

            }

            @Override
            public void onFailure(Call<List<RetroFavourite>> call, Throwable t) {

            }
        });


        rv1 = (RecyclerView) rootView.findViewById(R.id.secondrvr);
        rv1.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api1 = retrofit1.create(API.class);

        Call<List<RetroFavourite1>> call1 = api1.getRecommendation3();

        call1.enqueue(new Callback<List<RetroFavourite1>>() {
            @Override
            public void onResponse(Call<List<RetroFavourite1>> call1, Response<List<RetroFavourite1>> response) {

                List<RetroFavourite1> favouriteRetros1 = response.body();

                FavouriteRetro1 = response.body();
                adapter1 = new AdapterFavourite1(FavouriteRetro1);
                rv1.setAdapter(adapter1);


            }

            @Override
            public void onFailure(Call<List<RetroFavourite1>> call1, Throwable t) {

            }
        });


        return rootView;
    }

}
