package com.observer.spb.observer.data.info;

import android.support.annotation.NonNull;

import com.observer.spb.observer.data.local.LocalStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InfoModule {

    @Provides
    @Singleton
    @NonNull
    public AppIdGenerator provideAppIdGenerator(@NonNull LocalStorage localStorage) {
        return new AppIdGenerator(localStorage);
    }
}
