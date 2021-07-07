package com.oliva.data.model.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.oliva.data.model.entities.local.ArticleEntity;
import com.oliva.data.model.entities.local.ArticlesDao;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract ArticlesDao articlesDao();
}
