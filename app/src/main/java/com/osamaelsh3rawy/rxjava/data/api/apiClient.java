package com.osamaelsh3rawy.rxjava.data.api;

import com.osamaelsh3rawy.rxjava.data.model.posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiClient {
    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit retrofit = null;
    private   ApiServies apiServies;

    public static ApiServies getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(ApiServies.class);
    }

//    public Observable<List<posts>> getPosts(){
//        return apiServies.getPosts();
//    }
}
