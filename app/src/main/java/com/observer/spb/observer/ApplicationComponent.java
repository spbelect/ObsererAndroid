package com.observer.spb.observer;

import android.support.annotation.NonNull;

import com.observer.spb.observer.data.api.ApiModule;
import com.observer.spb.observer.data.info.InfoModule;
import com.observer.spb.observer.data.local.LocalStorageModule;
import com.observer.spb.observer.models.LoginModel;
import com.observer.spb.observer.ui.fragments.LoginFragment.LoginFragmentComponent;
import com.observer.spb.observer.ui.fragments.LoginFragment.LoginFragmentModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LocalStorageModule.class, InfoModule.class, ApiModule.class})
public interface ApplicationComponent {

    @NonNull
    LoginModel loginModel();

    ///

    @NonNull
    LoginFragmentComponent plus(@NonNull LoginFragmentModule loginFragmentModule);
}
