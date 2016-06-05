package com.observer.spb.observer.ui.presenters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.observer.spb.observer.models.LoginModel;
import com.observer.spb.observer.ui.views.LoginView;

import rx.Scheduler;
import rx.Subscription;

public class LoginPresenter extends BasePresenter<LoginView> {

    @NonNull
    private final LoginModel loginModel;

    @NonNull
    private final Config config;

    public LoginPresenter(@NonNull LoginModel loginModel, @NonNull Config config) {
        this.loginModel = loginModel;
        this.config = config;
    }

    public void registerUser(
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
        Subscription subscription = loginModel.sendDeviceInfo()
                .flatMap(success ->
                        loginModel.registerUser(name, familyName, fatherName, email, vk, telegram, fb, skype, twitter))
                .subscribeOn(config.ioScheduler())
                .observeOn(config.uiScheduler())
                .subscribe(
                        success -> executeIfViewBound(view -> view.onRegistered()),
                        error -> executeIfViewBound(view -> view.onFailedToRegister(error))
                );
        unsubscribeOnUnbindView(subscription);
    }

    @AutoValue
    public abstract static class Config {

        @NonNull
        public abstract Scheduler ioScheduler();

        @NonNull
        public abstract Scheduler uiScheduler();

        public static Config create(@NonNull Scheduler ioScheduler, @NonNull Scheduler uiScheduler) {
            return new AutoValue_LoginPresenter_Config(ioScheduler, uiScheduler);
        }
    }
}
