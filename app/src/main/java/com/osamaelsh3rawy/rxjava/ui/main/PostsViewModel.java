package com.osamaelsh3rawy.rxjava.ui.main;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.osamaelsh3rawy.rxjava.data.api.ApiServies;
import com.osamaelsh3rawy.rxjava.data.model.posts;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.osamaelsh3rawy.rxjava.data.api.apiClient.getClient;

public class PostsViewModel extends ViewModel {
    private String TAG = "PostsViewModel";
    ApiServies apiServies;
    MutableLiveData<List<posts>> PostsData = new MutableLiveData<>();
    MutableLiveData<String> Post = new MutableLiveData<>();

    public void getPosts() {
        apiServies = getClient();
        Observable observable = apiServies.getPosts();

        Observer<List<posts>> observer = new Observer<List<posts>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<posts> value) {

                PostsData.setValue(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

    }
}
