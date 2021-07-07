package remote;

import android.util.Log;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import configuration.NewsApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClientFactory {

    private static final String TAG = HttpClientFactory.class.getSimpleName();
    private static final String BASE_URL = "https://newsapi.org/";

    public NewsApi getNewsApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(NewsApi.class);
    }

    private OkHttpClient getHttpClient() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(message -> Log.d(TAG, message));
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .addInterceptor(new HttpSuccessInterceptor())
                .addInterceptor(logInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
