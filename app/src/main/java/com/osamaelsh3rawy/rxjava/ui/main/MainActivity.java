package com.osamaelsh3rawy.rxjava.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.osamaelsh3rawy.rxjava.R;
import com.osamaelsh3rawy.rxjava.data.model.posts;
import com.osamaelsh3rawy.rxjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getPosts();

        ActivityMainBinding mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        final PostAdapter postAdapter = new PostAdapter();
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setAdapter(postAdapter);

        postsViewModel.PostsData.observe(this, new Observer<List<posts>>() {
            @Override
            public void onChanged(List<posts> posts) {
                postAdapter.setPosts(posts);
            }
        });


    }
}
