package com.oliva.newsreader.listener;

import com.oliva.newsreader.mappers.ArticleItemViewModel;
import com.oliva.newsreader.mappers.NewsListViewModel;

public interface ArticleItemHandler {

    void onItemSelected(ArticleItemViewModel item);

}
