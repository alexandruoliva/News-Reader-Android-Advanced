package com.oliva.newsreader.mappers;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public final ObservableField<String> imageName;
    public final ObservableField<String> titleName;
    public final ObservableField<String> articleName;


    public ArticleItemViewModel(ObservableField<String> imageName, ObservableField<String> titleName, ObservableField<String> articleName) {
        this.imageName = imageName;
        this.titleName = titleName;
        this.articleName = articleName;
    }
}
