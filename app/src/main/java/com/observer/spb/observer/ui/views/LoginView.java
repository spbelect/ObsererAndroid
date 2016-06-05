package com.observer.spb.observer.ui.views;

import android.support.annotation.NonNull;

public interface LoginView {

    void onRegistered();

    void onFailedToRegister(@NonNull Throwable error);
}
