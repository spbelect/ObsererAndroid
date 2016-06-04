package com.observer.spb.observer.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.observer.spb.observer.ObserverApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalStorageModule {

    private final ObserverApplication context;

    public LocalStorageModule(@NonNull ObserverApplication context) {
        this.context = context;
    }

    @Provides
    @Singleton
    @NonNull
    public SharedPreferences provideSharedPrefferences() {
        return context.getSharedPreferences("LOCAL_STORAGE", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    @NonNull
    public LocalStorage provideLocalStorage(@NonNull SharedPreferences sharedPreffences) {
        return new SharedPreffsLocalStorage(sharedPreffences);
    }
}
