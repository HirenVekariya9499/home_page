package com.example.samcom.homepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class FragmentHome extends Fragment {

    String[] crime={"Blacklist","Crisis","Gotham","Banshee","Breaking Bad"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(homeRetroAPI.BASE_URL)
                .addConverterFactory( GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        homeRetroAPI api = retrofit.create(homeRetroAPI.class);

        Call<List<RetroHome>> call = api.getRecommendation();
        call.enqueue( new Callback<List<RetroHome>>() {
            @Override
            public void onResponse(Call<List<RetroHome>> call, Response<List<RetroHome>> response) {

                List<RetroHome> homeRetros = response.body();

//
//                String[]  = new String[homeRetros.size()];
//
//                //looping through all the heroes and inserting the names inside the string array
//                for (int i = 0; i < homeRetros.size(); i++) {
//                    heroes[i] = homeRetros.get(i).getName();
//                }

//                for (RetroHome h: homeRetros){
//                    Log.d( "uname",h.getUname() );
//                    Log.d( "password",h.getPassword() );
//
//
//                }


            }

            @Override
            public void onFailure(Call<List<RetroHome>> call, Throwable t) {

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_home,container,false);

        RecyclerView rv= (RecyclerView) rootView.findViewById(R.id.firstrv);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rv.setNestedScrollingEnabled(false);


        MyAdapter adapter=new MyAdapter(this.getActivity(),crime);
        rv.setAdapter(adapter);

        RecyclerView rv1= (RecyclerView) rootView.findViewById(R.id.secondrv);
        rv1.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv1.setNestedScrollingEnabled(false);


        MyAdapterShops adapter1=new MyAdapterShops(this.getActivity(),crime);
        rv1.setAdapter(adapter1);

        return rootView;

    }
}
