package com.oliva.newsreader.mappers;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public final String imageUrl;
    public final String titleName;
    public final String articleName;

    public ArticleItemViewModel(String imageUrl, String titleName, String articleName) {
        this.imageUrl = imageUrl;
        this.titleName = titleName;
        this.articleName = articleName;
    }
}
