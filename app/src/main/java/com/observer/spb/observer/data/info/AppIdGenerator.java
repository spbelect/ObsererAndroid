package com.observer.spb.observer.data.info;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.observer.spb.observer.data.local.LocalStorage;

import java.util.UUID;

import rx.Single;

import static android.text.TextUtils.isEmpty;

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
        return Single.fromCallable(() -> UUID.randomUUID().toString())
                .flatMap(id -> localStorage.saveAppId(id).map(whatever -> id));
    }
}
