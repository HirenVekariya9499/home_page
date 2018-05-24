package com.example.samcom.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ShoppageFragment extends Fragment {


    public static Fragment newInstance() {
        return new ShoppageFragment ();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppage_fragment,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());
        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private ImageView mImageView;
        private TextView mNameTextView;
        private TextView mDevTextView;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater,ViewGroup container){
            super(inflater.inflate(R.layout.shoppageitems,container,false));
            mCardView = itemView.findViewById(R.id.card_container);
            mImageView = itemView.findViewById(R.id.imageView);
            mNameTextView = itemView.findViewById(R.id.nameTextView);
            mDevTextView = itemView.findViewById(R.id.devTextView);

        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 7;
        }
    }

}
