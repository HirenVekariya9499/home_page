package com.example.samcom.homepage;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class homeFragment extends Fragment {

    private List<homeRetro> HomeRetro;
    private MyAdapter adapter;
    private List<homeRetro1> HomeRetro1;
    private MyAdapterShops adapter1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView=inflater.inflate(R.layout.fragment_home,container,false);

        final RecyclerView rv= (RecyclerView) rootView.findViewById(R.id.firstrv);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rv.setNestedScrollingEnabled(false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( homeRetroAPI.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        homeRetroAPI api = retrofit.create( homeRetroAPI.class );

        Call<List<homeRetro>> call = api.getRecommendation();

        call.enqueue( new Callback<List<homeRetro>>() {
            @Override
            public void onResponse(Call<List<homeRetro>> call, Response<List<homeRetro>> response) {

                List<homeRetro> homeRetros = response.body();

                    HomeRetro=response.body();
                Context context = null;
                adapter=new MyAdapter( HomeRetro, rootView);
                    rv.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<homeRetro>> call, Throwable t) {

            }
        } );



        final RecyclerView rv1= (RecyclerView) rootView.findViewById(R.id.secondrv);
        rv1.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv1.setNestedScrollingEnabled(false);
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl( homeRetroAPI.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() ) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        homeRetroAPI api1 = retrofit1.create( homeRetroAPI.class );

        Call<List<homeRetro1>> call1 = api1.getRecommendation1();

        call1.enqueue( new Callback<List<homeRetro1>>() {
            @Override
            public void onResponse(Call<List<homeRetro1>> call1, Response<List<homeRetro1>> response) {

                List<homeRetro1> homeRetros1 = response.body();

                HomeRetro1=response.body();
                adapter1=new MyAdapterShops( HomeRetro1,rootView);
                rv1.setAdapter( adapter1 );
            }

            @Override
            public void onFailure(Call<List<homeRetro1>> call, Throwable t) {

            }
        } );

        return rootView;

    }
}
