package com.observer.spb.observer.data.api;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.observer.spb.observer.data.api.requests.AppInfoRequest;

import retrofit2.http.Body;
import retrofit2.http.PUT;
import rx.Single;

public interface SpbObserversApi {

    @PUT("/api/v1/user/location")
    @CheckResult
    @NonNull
    Single<Void> registerUser(@NonNull @Body AppInfoRequest request);

}
