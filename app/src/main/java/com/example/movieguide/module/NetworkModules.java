package com.example.movieguide.module;

import com.example.movieguide.BuildConfig;
import com.example.movieguide.helper.RequestInterceptor;
import com.example.movieguide.services.TmdbWebService;

import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Module
public class NetworkModules {
    public static final int CONNECT_TIMEOUT_IN_MS = 30000;

    @Provides
    @Singleton
    Interceptor requestInterceptor(RequestInterceptor interceptor) {
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(RequestInterceptor requestInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .addInterceptor(requestInterceptor);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit
                .Builder()
                .baseUrl(BuildConfig.TMDB_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    TmdbWebService tmdbWebService(Retrofit retrofit) {
        return retrofit.create(TmdbWebService.class);
    }

}

