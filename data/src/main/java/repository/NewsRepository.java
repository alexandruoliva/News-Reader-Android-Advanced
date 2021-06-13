package repository;

import com.oliva.data.model.Article;
import com.oliva.data.model.entities.local.ArticleEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository{

    @NonNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Single<ArticleEntity> getArticleById(int articleId);

    @NonNull
    Completable saveArticle(ArticleEntity articleEntity);

    @NonNull
    Completable deleteArticle(int articleId);
}
