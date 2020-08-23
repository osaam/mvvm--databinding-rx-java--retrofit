package com.osamaelsh3rawy.rxjava.data.api;

import com.osamaelsh3rawy.rxjava.data.model.posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServies {


    @GET("posts")
    Observable<List<posts>> getPosts();
}
