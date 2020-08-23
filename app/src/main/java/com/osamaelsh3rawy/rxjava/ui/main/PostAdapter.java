package com.osamaelsh3rawy.rxjava.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.osamaelsh3rawy.rxjava.R;
import com.osamaelsh3rawy.rxjava.data.model.posts;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    public List<posts> Postdata = new ArrayList<>();
    private Context context;

//    public PostAdapter(List<posts> postdata) {
//        Postdata = postdata;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate((R.layout.recycler), parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        posts post = Postdata.get(position);

        holder.body.setAnimation(AnimationUtils.loadAnimation(context, R.anim.rv_copleat));

        holder.titel.setText(post.getTitle());
        holder.userId.setText(post.getUser_id());
        holder.body.setText(post.getBody());
    }


    @Override
    public int getItemCount() {
        return Postdata.size();
    }


    public void setPosts(List<posts> posts) {
        this.Postdata = posts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titel, userId, body;
        Typeface typeface;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titel = itemView.findViewById(R.id.title);
            userId = itemView.findViewById(R.id.userid);
            body = itemView.findViewById(R.id.body);
            //////
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Lobster-Regular.ttf");
            titel.setTypeface(typeface);
            body.setTypeface(typeface);
        }
    }
}
