package com.oliva.newsreader;

import android.app.Application;

import dependencyInjection.RepoModule;


public class NewsApplication extends Application {

    //move along, will be replaced with Dagger later
    private static RepoModule repoModule;

    public static RepoModule getRepoProvider() {
        return repoModule;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.repoModule = new RepoModule(this);
    }
}