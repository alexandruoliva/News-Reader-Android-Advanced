package com.oliva.data.model;

import io.reactivex.annotations.NonNull;
public class Article {

    @NonNull
    public String imageUrl;
    @NonNull
    public String title;
    @NonNull
    public String content;
    @NonNull
    public String description;

    public Article(){}

    public Article(@NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }


    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
