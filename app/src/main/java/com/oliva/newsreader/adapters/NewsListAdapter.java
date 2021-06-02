package com.oliva.newsreader.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oliva.newsreader.databinding.ArticleItemBinding;
import com.oliva.newsreader.listener.ArticleItemHandler;
import com.oliva.newsreader.mappers.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ArticleViewHolder> {


    private List<ArticleItemViewModel> articleItemViewModelList;
    private ArticleItemHandler handler;

    public NewsListAdapter(ArticleItemHandler handler) {
        this.articleItemViewModelList = new ArrayList<>();
        this.handler = handler;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleItemBinding binder = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new ArticleViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.binding.setItemViewModel(articleItemViewModelList.get(position));
        // point all clicks to a single interface for all items
        holder.binding.setHandler(handler);
    }

    @Override
    public int getItemCount() {
        return articleItemViewModelList.size();
    }

    public void setItems(List<ArticleItemViewModel> items/*, ArticleItemHandler handler*/) {
//        this.handler = handler;
        this.articleItemViewModelList = items;
        notifyDataSetChanged();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;

        public ArticleViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
