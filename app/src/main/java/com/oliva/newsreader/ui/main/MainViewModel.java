package com.oliva.newsreader.ui.main;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

import com.oliva.data.entities.Article;
import com.oliva.newsreader.R;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import reactive.SingleLiveEvent;
import repository.NewsRepository;

public class MainViewModel extends AndroidViewModel {


    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;


    public MainViewModel(@NonNull Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @SuppressLint("CheckResult")
    public void refreshData() {
        isLoading.set(true);
        repo.getNewsArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<Article> articles) {
        isLoading.set(false);
        resultText.set(getApplication().getString(R.string.results, articles.size()));
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }


}