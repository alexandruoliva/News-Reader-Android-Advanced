package com.oliva.newsreader.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.oliva.newsreader.databinding.MainFragmentBinding;
import com.oliva.newsreader.mappers.NewsListViewModel;

public class SingleArticleFragment extends Fragment {

    private NewsListViewModel newsListViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newsListViewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        getLifecycle().addObserver(newsListViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        MainFragmentBinding binding = MainFragmentBinding.inflate(inflater, container, false);

        binding.setItemListViewModel(newsListViewModel);

        return binding.getRoot();
    }
}
