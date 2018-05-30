package com.example.samcom.homepage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.appcompat.R.color.material_blue_grey_900;
import static android.support.v7.appcompat.R.color.material_deep_teal_500;


public class ShoppageFragment extends Fragment  {

    private List<Contact> contacts;
    private Datainterface apiInterface;
    private Datainterface api;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RViewAdapter rViewAdapter;

        public static Fragment newInstance() {
        return new ShoppageFragment ();

    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.shoppage_fragment,container,false);

            ImageView backimage = view.findViewById(R.id.backimage);
            String urlbi = "http://i.dailymail.co.uk/i/pix/2018/02/02/18/48D3379500000578-5345305-image-a-16_1517595669475.jpg";
            Picasso.get().load(urlbi).into(backimage);

             ImageView shopimage = view.findViewById(R.id.shopimage);
             String urlsi = "https://scontent.fbom1-2.fna.fbcdn.net/v/t1.0-1/c0.25.200.200/p200x200/11001942_860514844006683_5989534201608140092_n.jpg?_nc_cat=0&oh=cfae2b9c35d9a6b655c6f7beac6245a3&oe=5BB9180F";
             Picasso.get().load(urlsi).into(shopimage);






            final RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            //recyclerView.setAdapter(new RecyclerViewAdapter());
            recyclerView.setHasFixedSize(true);

            apiInterface = Datacalling.getDatacalling().create(Datainterface.class);
            Call<List<Contact>> call = apiInterface.getContacts();


            call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                contacts = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(contacts);
                recyclerView.setAdapter(recyclerViewAdapter);


            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });


        RecyclerView rv = view.findViewById(R.id.category);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(new RViewAdapter());
        return view;

    }




    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private TextView uname;
        private TextView password;
        private TextView mnumber;
        private TextView countertext;
        private Button minus;
        private Button plus;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater,ViewGroup container){
            super(inflater.inflate(R.layout.shoppageitems,container,false));
            mCardView = itemView.findViewById(R.id.card_container);
            uname = itemView.findViewById(R.id.name);
            password = itemView.findViewById(R.id.pass);
            mnumber = itemView.findViewById(R.id.mno);
            countertext = itemView.findViewById(R.id.counttext);
            minus = itemView.findViewById(R.id.minusbn);
            plus = itemView.findViewById(R.id.plusbn);


            }





    }



    private class RViewHolder extends RecyclerView.ViewHolder{
        private CardView xCardView;
        private TextView category;




        public RViewHolder(View itemView) {
            super(itemView);
        }

        public RViewHolder(LayoutInflater inflater,ViewGroup container){
            super(inflater.inflate(R.layout.category,container,false));
            xCardView = itemView.findViewById(R.id.card_containerx);
            category = itemView.findViewById(R.id.idid);



        }

    }




    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        private List<Contact> contacts;



        public RecyclerViewAdapter(List<Contact>contacts){

            this.contacts = contacts;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());


            return new RecyclerViewHolder(inflater,parent);
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {

            final int[] counter = {0};
            holder.mCardView.setCardBackgroundColor(material_blue_grey_900);
            //holder.mCardView.setTag(position);
            holder.uname.setText(contacts.get(position).getuname());
            holder.password.setText(contacts.get(position).getpassword());
            holder.mnumber.setText(contacts.get(position).getmnumber());


            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   counter[0]++;

                   holder.countertext.setText(""+ counter[0]);
                }
            });

            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(counter[0] >0){
                        counter[0]--;
                        holder.countertext.setText(""+ counter[0]);

                    }
                }
            });

            Log.d( "onBindViewHolder: ", String.valueOf(holder.countertext));

//            if (counter[0]!=0){
//
//                holder.mCardView.setCardBackgroundColor(material_deep_teal_500);
//
//          }

        }


        public int getItemCount() {
//            class Myviewholder extends RecyclerView.ViewHolder{
//
//                TextView uname,password,mnumber;
//                public Myviewholder(View itemView) {
//                    super(itemView);
//
//                    uname = (TextView)itemView.findViewById(R.id.name);
//                    password = (TextView)itemView.findViewById(R.id.pass);
//                    mnumber = (TextView)itemView.findViewById(R.id.mno);
//                }
//            }
            return contacts.size();
        }
    }




    private class RViewAdapter extends RecyclerView.Adapter<RViewHolder>{

        @NonNull
        @Override
        public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RViewHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RViewHolder rViewHolder, int position) {
           // rViewHolder.xCardView.setTag(contacts.get(position));
        }

        @Override
        public int getItemCount() {
            return 7;
        }
    }



}
