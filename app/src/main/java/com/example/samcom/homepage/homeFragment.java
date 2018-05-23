package com.example.samcom.homepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    String[] crime={"Blacklist","Crisis","Gotham","Banshee","Breaking Bad"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_home,container,false);

        RecyclerView rv= (RecyclerView) rootView.findViewById(R.id.firstrv);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));

        MyAdapter adapter=new MyAdapter(this.getActivity(),crime);
        rv.setAdapter(adapter);

        RecyclerView rv1= (RecyclerView) rootView.findViewById(R.id.secondrv);
        rv1.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        MyAdapter adapter1=new MyAdapter(this.getActivity(),crime);
        rv1.setAdapter(adapter1);

        return rootView;
    }
}
