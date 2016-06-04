package com.observer.spb.observer;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.observer.spb.observer.data.api.ApiModule;
import com.observer.spb.observer.data.info.InfoModule;
import com.observer.spb.observer.data.local.LocalStorageModule;

public class ObserverApplication extends Application {

    @NonNull
    public static ObserverApplication app(@NonNull Context context) {
        return (ObserverApplication) context.getApplicationContext();
    }

    @NonNull
    public static ApplicationComponent appComponent(@NonNull Context context) {
        return ((ObserverApplication) context.getApplicationContext()).applicationComponent;
    }

    @SuppressWarnings("NullableProblems") // onCreate
    @NonNull
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .apiModule(new ApiModule())
                .localStorageModule(new LocalStorageModule(this))
                .infoModule(new InfoModule())
                .build();
    }
}
