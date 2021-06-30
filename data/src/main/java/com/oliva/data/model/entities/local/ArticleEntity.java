package com.oliva.data.model.entities.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;
    public final String title;
    public final String content;
    public final String imageUrl;
    public final String description;

    public ArticleEntity(String title, String content, String imageUrl, String description) {

        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.description = description;
    }
}
