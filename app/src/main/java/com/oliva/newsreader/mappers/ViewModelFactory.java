package com.oliva.newsreader.mappers;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.oliva.newsreader.MainActivity;
import com.oliva.newsreader.repository.ArticleItemRepository;

public class ViewModelFactory /*implements ViewModelProvider.Factory*/ {
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(ArticleItemViewModel.class)) {
//            ArticleItemRepository repo = MainActivity.getRepoProvider().provideToDoRepository();
//            return (T) new ToDoViewModel(repo);
//        }
//
//        if (modelClass.isAssignableFrom(ToDoDetailsViewModel.class)) {
//            ToDoRepository repo = ToDoApplication.getRepoProvider().provideToDoRepository();
//            return (T) new ToDoDetailsViewModel(repo);
//        }
//
//        throw new IllegalArgumentException("Unknown ViewModel class");
//    }
}
