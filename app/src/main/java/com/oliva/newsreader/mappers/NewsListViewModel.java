package com.oliva.newsreader.mappers;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.oliva.newsreader.listener.ArticleItemHandler;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import reactive.SingleLiveEvent;
import repository.NewsRepository;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver, ArticleItemHandler {


    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    private final NewsRepository repo;
    private static final String LINK = "https://newsapi.org/";

    @NonNull
    public ObservableList<ArticleItemViewModel> items;

    public NewsListViewModel(@NonNull Application application, NewsRepository repo) {
        super(application);
        this.items = new ObservableArrayList<>();

        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {
    }

    @Override
    public void onCleared(){
        super.onCleared();
    }


    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refreshData() {
        isLoading.set(true);
        repo.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        this.items.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }



}
