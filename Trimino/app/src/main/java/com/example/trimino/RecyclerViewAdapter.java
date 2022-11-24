package com.example.trimino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<String> mUser = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mTime = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mUser, ArrayList<String> mTitle, ArrayList<String> mTime, ArrayList<String> mDescription, Context mContext) {
        this.mUser = mUser;
        this.mTitle = mTitle;
        this.mTime = mTime;
        this.mDescription = mDescription;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_child_coupon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.user.setText(mUser.get(position));
        holder.title.setText(mTitle.get(position));
        holder.time.setText(mTime.get(position));
        holder.description.setText(mDescription.get(position));
//        Glide.with(mContext).asBitmap().load(mUrl.get(position)).into(holder.URL);
//        Glide.with(mContext).asBitmap().load(mThumbnailUrl.get(position)).into(holder.thumbnailUrl);
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView user, time, title, description;
        ConstraintLayout rowChild;
        ImageView image,star;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.showuser);
            time = itemView.findViewById(R.id.showtime);
            title = itemView.findViewById(R.id.showtitle);
            description = itemView.findViewById(R.id.showdescription);
            rowChild = itemView.findViewById(R.id.row_child);
        }
    }
}
