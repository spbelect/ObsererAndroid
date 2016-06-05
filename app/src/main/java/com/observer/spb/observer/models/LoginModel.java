package com.observer.spb.observer.models;

import android.os.Build;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.observer.spb.observer.data.api.SpbObserversApi;
import com.observer.spb.observer.data.api.requests.AppInfoRequest;
import com.observer.spb.observer.data.api.requests.RegisterRequest;
import com.observer.spb.observer.data.info.AppIdGenerator;

import java.util.Date;

import javax.inject.Inject;

import rx.Single;

public class LoginModel {

    @NonNull
    private final AppIdGenerator appIdGenerator;

    @NonNull
    private final SpbObserversApi spbObserversApi;

    @Inject
    public LoginModel(@NonNull AppIdGenerator appIdGenerator, @NonNull SpbObserversApi spbObserversApi) {
        this.appIdGenerator = appIdGenerator;
        this.spbObserversApi = spbObserversApi;
    }

    @CheckResult
    @NonNull
    public Single<Void> sendDeviceInfo() {
        return appIdGenerator.appDeviceId()
                .flatMap(appId -> spbObserversApi.registerAppId(
                        AppInfoRequest.builder()
                                .appId(appId)
                                .osVersion("Android, SDK: " + Build.VERSION.SDK_INT)
                                .timestamp(new Date())
                                .build()
                        )
                );
    }

    @CheckResult
    @NonNull
    public Single<Void> registerUser(
            @NonNull String name,
            @NonNull String familyName,
            @Nullable String fatherName,
            @Nullable String email,
            @Nullable String vk,
            @Nullable String telegram,
            @Nullable String fb,
            @Nullable String skype,
            @Nullable String twitter
    ) {
        return appIdGenerator.appDeviceId()
                .flatMap(appId -> spbObserversApi.registerUser(
                        RegisterRequest.builder()
                                .appId(appId)
                                .timestamp(new Date())
                                .name(name)
                                .familyName(familyName)
                                .fatherName(fatherName)
                                .email(email)
                                .vk(vk)
                                .telegram(telegram)
                                .fb(fb)
                                .skype(skype)
                                .twitter(twitter)
                                .build()
                        )
                );
    }
}
