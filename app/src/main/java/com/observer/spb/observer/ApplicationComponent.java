package com.observer.spb.observer;

import com.observer.spb.observer.data.api.ApiModule;
import com.observer.spb.observer.data.info.InfoModule;
import com.observer.spb.observer.data.local.LocalStorageModule;

import dagger.Component;

@Component(modules = {LocalStorageModule.class, InfoModule.class, ApiModule.class})
public interface ApplicationComponent {


}
