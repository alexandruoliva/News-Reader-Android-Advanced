package com.oliva.newsreader.mappers;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.oliva.newsreader.listener.ArticleItemHandler;

public class NewsListViewModel extends ViewModel implements LifecycleObserver, ArticleItemHandler {

    public static final String TAG = NewsListViewModel.class.getName();

    @Nullable
    public Integer id;
    @NonNull
    public final ObservableList<ArticleItemViewModel> items;

    public NewsListViewModel(@NonNull ObservableList<ArticleItemViewModel> newsList) {
        super();
        this.items = new ObservableArrayList<>();
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {
    }

    @Override
    public void onCleared(){
        super.onCleared();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void fetchNewsList(){
        Log.d(TAG,"fetchNewsList()");
        if(items.isEmpty()){
            items.add(new ArticleItemViewModel("https://imgur.com/gallery/dDXwhHY", "title 1", "description"));
            items.add(new ArticleItemViewModel("https://imgur.com/gallery/dDXwhHY", "title 1", "description"));
            items.add(new ArticleItemViewModel("https://imgur.com/gallery/dDXwhHY", "title 1", "description"));
            items.add(new ArticleItemViewModel("https://imgur.com/gallery/dDXwhHY", "title 1", "description"));
            items.add(new ArticleItemViewModel("https://imgur.com/gallery/dDXwhHY", "title 1", "description"));
            items.add(new ArticleItemViewModel("https://imgur.com/gallery/dDXwhHY", "title 1", "description"));
        }
    }
}
