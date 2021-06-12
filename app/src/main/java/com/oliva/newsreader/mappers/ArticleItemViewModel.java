package com.oliva.newsreader.mappers;

import androidx.annotation.Nullable;


public class ArticleItemViewModel {

    public final String imageUrl;
    public final String titleName;
    public final String content;

    public ArticleItemViewModel(String imageUrl, String titleName, String content) {
        this.imageUrl = imageUrl;
        this.titleName = titleName;
        this.content = content;
    }
}
