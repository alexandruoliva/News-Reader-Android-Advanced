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
import mapper.NewsDtoToNewsMapper;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    private NewsLocalStore newsLocalStore;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalStore newsLocalStore) {
        this.remoteSource = remoteSource;
        this.newsLocalStore = newsLocalStore;
    }

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @NonNull
    @Override
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());
    }

//    @Override
//    @NonNull
//    public Single<List<Article>> getNewsArticles() {
//        return remoteSource.getNewsArticles()
//                .doOnSuccess(newsLocalStore::saveArticle)
//                .onErrorResumeNext(remoteSource.getNewsArticles())
//                .map(new NewsDtoToNewsMapper());
//    }



    @NonNull
    @Override
    public Single<ArticleEntity> getArticleById(int articleId) {
        return newsLocalStore.getArticleById(articleId)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Completable saveArticle(ArticleEntity articleEntity) {
        return newsLocalStore.saveArticle(articleEntity)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Completable deleteArticle(int articleId) {
        return newsLocalStore.deleteArticle(articleId)
                .subscribeOn(Schedulers.io());
    }

}
