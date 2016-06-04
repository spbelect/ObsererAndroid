package com.observer.spb.observer.data.info;

import android.os.Build;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.observer.spb.observer.data.local.LocalStorage;

import java.util.Random;

import rx.Single;

import static android.text.TextUtils.isEmpty;

/**
 * Handles uniq AppId. Will create id at first request and save it in local storage.
 */
public class AppIdGenerator {

    @NonNull
    private final LocalStorage localStorage;

    public AppIdGenerator(@NonNull LocalStorage localStorage) {
        this.localStorage = localStorage;
    }

    @CheckResult
    @NonNull
    public Single<String> appDeviceId() {
        return localStorage
                .getAppId()
                .flatMap(id -> isEmpty(id) ? generateNewId() : Single.just(id));
    }

    @CheckResult
    @NonNull
    private Single<String> generateNewId() {
        // TODO: is it good enough?
        return Single.fromCallable(() -> Build.SERIAL + (new Random().nextInt(10000)))
                .flatMap(id -> localStorage.saveAppId(id).map(whatever -> id));
    }
}
