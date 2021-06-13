package com.oliva.data.model.entities.local;

import com.oliva.data.model.ArticleListDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class NewsLocalStore {
    private ArticlesDao dao;

    public NewsLocalStore(ArticlesDao dao) {
        this.dao = dao;
    }

    public Flowable<List<ArticleEntity>> getArticlesList() {
        return dao.queryArticles();
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

}
