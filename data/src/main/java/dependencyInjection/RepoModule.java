package dependencyInjection;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.oliva.data.model.entities.local.NewsLocalStore;
import com.oliva.data.model.store.local.NewsDatabase;

import configuration.NewsRemoteSource;
import io.reactivex.annotations.NonNull;
import remote.HttpClientFactory;
import repository.NewsRepository;
import repository.NewsRepositoryImpl;

public class RepoModule {

    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideNewLocalSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {

        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    private NewsLocalStore provideNewLocalSource(){
        NewsDatabase database = getInstance();
        return new NewsLocalStore(database.articlesDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "News.db")
                            .build();
                }
            }
        }
        return database;
    }
}
