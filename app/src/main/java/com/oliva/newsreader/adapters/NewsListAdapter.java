package com.oliva.newsreader.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oliva.newsreader.listener.ArticleItemHandler;
import com.oliva.newsreader.mappers.ArticleItemViewModel;
import com.oliva.newsreader.mappers.NewsListViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter {


    private List<ArticleItemViewModel> articleItemViewModelList;
    private ArticleItemHandler handler;

    public NewsListAdapter(){ this.articleItemViewModelList = new ArrayList<>();
//
//    @Override
//    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        NewsItemBinding binder = TodoItemBinding.inflate(LayoutInflater.from(parent.getContext()),
//                parent, false);
//
//        return new TaskViewHolder(binder);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
//        holder.binding.setViewModel(taskModelList.get(position));
//        //point all clicks to a single interface for all items
//        holder.binding.setHandler(handler);
//    }
//
//    @Override
//    public int getItemCount() {
//        return taskModelList.size();
//    }
//
//    public void setItems(List<ToDoItemViewModel> items, ToDoHandler handler) {
//        this.handler = handler;
//        this.taskModelList = items;
//        notifyDataSetChanged();
//    }
//
//
//    public class NewsViewHolder extends RecyclerView.ViewHolder {
//        final NewsItemBinding binding;
//
//        public NewsViewHolder(NewsItemBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
    }

}
