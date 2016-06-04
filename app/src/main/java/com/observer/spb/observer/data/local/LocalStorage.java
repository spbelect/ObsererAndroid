package com.observer.spb.observer.data.local;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import rx.Single;

public interface LocalStorage {

    @CheckResult
    @NonNull
    Single<String> getAppId();

    @CheckResult
    @NonNull
    Single<Void> saveAppId(@NonNull String id);
}
