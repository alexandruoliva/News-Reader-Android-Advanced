package com.oliva.data.model.entities.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String title;

    public String content;

    public String imageUrl;

    public String description;

}
