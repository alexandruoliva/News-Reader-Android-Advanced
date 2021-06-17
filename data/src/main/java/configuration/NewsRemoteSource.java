package configuration;

import com.oliva.data.model.Article;
import com.oliva.data.model.ArticleListDto;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import mapper.NewsDtoToNewsMapper;

public class NewsRemoteSource {


    private static final String API_KEY = "397fb628c7bd4a95b23c504ac745d189";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io()).map(new NewsDtoToNewsMapper());
    }
}
