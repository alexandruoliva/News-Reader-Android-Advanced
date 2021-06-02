package com.oliva.newsreader.view.bindings;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oliva.newsreader.adapters.NewsListAdapter;
import com.oliva.newsreader.listener.ArticleItemHandler;
import com.oliva.newsreader.mappers.ArticleItemViewModel;
import com.oliva.newsreader.mappers.NewsListViewModel;

import java.util.List;

public class RecyclerBindings {
    @BindingAdapter({"items", "handler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles, ArticleItemHandler handler) {
        NewsListAdapter readerAdapter = (NewsListAdapter) recyclerView.getAdapter();

        if (readerAdapter == null) {
            readerAdapter = new NewsListAdapter(handler);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(readerAdapter);
        }

        readerAdapter.setItems(articles);
    }
}
