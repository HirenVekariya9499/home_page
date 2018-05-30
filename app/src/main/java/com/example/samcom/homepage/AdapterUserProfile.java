package com.example.samcom.homepage;

        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.bumptech.glide.Glide;

        import java.util.List;

public class AdapterUserProfile extends RecyclerView.Adapter<HolderUserProfile> {

    List<RetroUserProfile> UserProfileRetro;
//    View view;



    public AdapterUserProfile(List<RetroUserProfile> UserProfileRetro) {
        this.UserProfileRetro =UserProfileRetro;
//        this.view=view;
    }

    @Override
    public HolderUserProfile onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.item_user_profile,parent,false);

        return new HolderUserProfile(v);
    }

    @Override
    public void onBindViewHolder(HolderUserProfile holder, int position) {
        holder.uname.setText(UserProfileRetro.get(position).getUname());
        holder.mnumber.setText(UserProfileRetro.get(position).getMnumber());


//        Glide.with(view)
//                .load(HomeRetro.get(position).getImageurl())
//                .into(holder.imageurl);

    }

    @Override
    public int getItemCount() {
        int one=1;
        return one;
    }
}
