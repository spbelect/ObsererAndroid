package com.observer.spb.observer.data.api;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import timber.log.Timber;

@Module
public class ApiModule {

    @Provides
    @Singleton
    @NonNull
    public OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Timber.d(message));
        return new OkHttpClient.Builder().addInterceptor(logging).build();
    }

    @Provides
    @Singleton
    @NonNull
    public SpbObserversApi provideApiModule(@NonNull OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("www.teeeest.com" /* TODO: add real url */)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(SpbObserversApi.class);
    }
}
