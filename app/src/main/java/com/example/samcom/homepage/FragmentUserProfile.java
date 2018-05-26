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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUserProfile extends Fragment {

    private List<RetroUserProfile> UserProfileRetro;
    private AdapterUserProfile adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView=inflater.inflate(R.layout.fragment_userprofile,container,false);

        final RecyclerView rv= (RecyclerView) rootView.findViewById(R.id.firstrvp);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setNestedScrollingEnabled(false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( API.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create( API.class );

        Call<List<RetroUserProfile>> call = api.getRecommendation4();

        call.enqueue( new Callback<List<RetroUserProfile>>() {
            @Override
            public void onResponse(Call<List<RetroUserProfile>> call, Response<List<RetroUserProfile>> response) {

                List<RetroUserProfile> UserProfileRetros = response.body();

                UserProfileRetro=response.body();
                adapter=new AdapterUserProfile(UserProfileRetro);
                rv.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<RetroUserProfile>> call, Throwable t) {

            }
        } );
        return rootView;

    }

}
