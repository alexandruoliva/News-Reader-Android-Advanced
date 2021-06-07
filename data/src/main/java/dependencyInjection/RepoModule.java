package dependencyInjection;

import android.app.Application;
import android.content.Context;

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

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
