//package com.example.samcom.homepage;
//
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
////import com.bumptech.glide.Glide;
//
//import org.w3c.dom.Text;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class adapter_home_recommendation  extends RecyclerView.Adapter<adapter_home_recommendation.ViewHolder>{
//
//    Context c;
//    String[] movies;
//
//    public adapter_home_recommendation(Context c, String[] movies) {
//        this.c = c;
//        this.movies = movies;
//    }
//
//
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item__home_recommendation,parent,false);
//
//        return new ViewHolder(v);
//    }
//
//    @SuppressLint("LongLogTag")
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//
//
//        holder.storeName.setText(movies[position]);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return movies.length;
//    }
//
//    //ViewHolder
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView image;
//        TextView imageName,storeName;
//
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            image = itemView.findViewById(R.id.imageView);
//            imageName = itemView.findViewById(R.id.itemname);
//            storeName = itemView.findViewById(R.id.storename);
//        }
//    }
//
//}
