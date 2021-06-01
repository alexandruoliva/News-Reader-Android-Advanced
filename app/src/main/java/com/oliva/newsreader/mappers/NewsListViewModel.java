package com.oliva.newsreader.mappers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

public class NewsListViewModel {

    @Nullable
    public Integer id;
    @NonNull
    public final ObservableList<ArticleItemViewModel> items;

    public NewsListViewModel(@NonNull ObservableList<ArticleItemViewModel> newsList) {
        this.items = new ObservableArrayList<>();
    }
}
