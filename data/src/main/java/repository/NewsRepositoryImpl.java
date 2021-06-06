package repository;

import com.oliva.data.entities.Article;

import java.util.List;

import configuration.NewsRemoteSource;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import mapper.NewsDtoToNewsMapper;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @NonNull
    @Override
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());
    }
}
