package com.oliva.data.entities;

import io.reactivex.annotations.NonNull;
public class Article {

    @NonNull
    public final String imageUrl;
    @NonNull
    public final String title;
    @NonNull
    public final String content;
    @NonNull
    public final String description;

    public Article(@NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
