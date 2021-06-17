package com.oliva.data.model.entities.local;

import com.oliva.data.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import mapper.ArticleToNewsEntityMapper;
import mapper.EntitiesToArticlesMapper;

public class NewsLocalStore {
    private ArticlesDao dao;

    public NewsLocalStore(ArticlesDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticlesList() {
        return dao.queryArticles().map(new EntitiesToArticlesMapper());
    }

    public Single<ArticleEntity> getArticleById(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteArticle(int id) {
        return dao.deleteArticleItem(id);
    }

    public Completable saveArticle(ArticleEntity article) {
        if (article.id == null) {
            return dao.insertArticle(article);
        } else {
            return dao.updateArticle(article.title, article.imageUrl, article.content, article.description, article.id);
        }
    }

    public void saveArticles(List<Article> articles) {
        Single.just(articles).map(new ArticleToNewsEntityMapper())
                .flatMapCompletable((entityList) -> dao
                        .insertArticles(entityList))
                .subscribeOn(Schedulers.io()).subscribe();
    }
}
