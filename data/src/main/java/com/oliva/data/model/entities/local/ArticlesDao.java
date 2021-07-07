package com.oliva.data.model.entities.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ArticlesDao {

    @Query("SELECT * FROM articles")
    Single<List<ArticleEntity>> queryArticles();

    @Query("SELECT * FROM articles where id= :id")
    Single<ArticleEntity> queryArticleItem(int id);

    @Query("DELETE FROM articles where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM articles")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);

    @Query("UPDATE articles SET title = :title, imageUrl = :imageUrl, content = :content, description = :description where id=:id")
    Completable updateArticle(String title, String imageUrl, String content, String description,  Integer id);

}
