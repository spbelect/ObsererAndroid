package com.observer.spb.observer.data.local;

import android.content.SharedPreferences;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import rx.Single;

// TODO: REPLACE WITH BETTER STORAGE OR AT LEAST WITH OBFUSCATED PREFERENCES!
public class SharedPreffsLocalStorage implements LocalStorage {

    public static final String APP_ID_KEY = "APP_ID";

    @NonNull
    private final SharedPreferences preferences;

    public SharedPreffsLocalStorage(@NonNull SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @CheckResult
    @NonNull
    @Override
    public Single<String> getAppId() {
        return Single.fromCallable(() -> preferences.getString(APP_ID_KEY, null));
    }

    @CheckResult
    @NonNull
    @Override
    public Single<Void> saveAppId(@NonNull String id) {
        return Single.fromCallable(() -> {
                    preferences.edit().putString(APP_ID_KEY, APP_ID_KEY).commit();
                    return null;
                }
        );
    }
}
