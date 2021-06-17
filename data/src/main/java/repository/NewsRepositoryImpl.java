package repository;

import com.oliva.data.model.Article;
import com.oliva.data.model.entities.local.ArticleEntity;
import com.oliva.data.model.entities.local.NewsLocalStore;

import java.util.List;

import configuration.NewsRemoteSource;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import mapper.ArticleToNewsEntityMapper;
import mapper.NewsDtoToNewsMapper;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    private NewsLocalStore localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalStore localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localSource::saveArticles)
                .onErrorResumeNext(localSource.getArticlesList());
    }



    @NonNull
    @Override
    public Single<ArticleEntity> getArticleById(int articleId) {
        return localSource.getArticleById(articleId)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Completable saveArticle(ArticleEntity articleEntity) {
        return localSource.saveArticle(articleEntity)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Completable deleteArticle(int articleId) {
        return localSource.deleteArticle(articleId)
                .subscribeOn(Schedulers.io());
    }

}
