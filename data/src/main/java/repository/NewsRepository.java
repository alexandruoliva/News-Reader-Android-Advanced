package repository;

import com.oliva.data.entities.Article;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository{

    @NonNull
    Single<List<Article>> getNewsArticles();
}
