package com.oliva.newsreader.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oliva.newsreader.databinding.SingleItemFragmentBinding;
import com.oliva.newsreader.listener.ArticleItemHandler;
import com.oliva.newsreader.mappers.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ArticleViewHolder> {


    private List<ArticleItemViewModel> articleItemViewModelList;
    private ArticleItemHandler handler;

    public NewsListAdapter(){
        this.articleItemViewModelList = new ArrayList<>();}

     public class ArticleViewHolder extends RecyclerView.ViewHolder {
        final SingleItemFragmentBinding binding;

        public ArticleViewHolder(SingleItemFragmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SingleItemFragmentBinding binder = SingleItemFragmentBinding.inflate(LayoutInflater.from(parent.getContext()),
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

    public void setItems(List<ArticleItemViewModel> items, ArticleItemHandler handler) {
        this.handler = handler;
        this.articleItemViewModelList = items;
        notifyDataSetChanged();
    }

}
