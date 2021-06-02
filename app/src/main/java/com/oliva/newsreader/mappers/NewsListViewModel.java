package com.oliva.newsreader.mappers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

import com.oliva.newsreader.listener.ArticleItemHandler;

public class NewsListViewModel extends ViewModel implements LifecycleObserver, ArticleItemHandler {

    @Nullable
    public Integer id;
    @NonNull
    public final ObservableList<ArticleItemViewModel> items;

    public NewsListViewModel(@NonNull ObservableList<ArticleItemViewModel> newsList) {
        this.items = new ObservableArrayList<>();
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }
}
