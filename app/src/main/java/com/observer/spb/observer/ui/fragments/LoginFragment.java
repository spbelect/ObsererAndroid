package com.observer.spb.observer.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.observer.spb.observer.R;
import com.observer.spb.observer.models.LoginModel;
import com.observer.spb.observer.ui.presenters.LoginPresenter;
import com.observer.spb.observer.ui.views.LoginView;

import butterknife.ButterKnife;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

import static com.observer.spb.observer.ObserverApplication.appComponent;
import static com.observer.spb.observer.ui.presenters.LoginPresenter.Config.create;
import static rx.android.schedulers.AndroidSchedulers.mainThread;
import static rx.schedulers.Schedulers.io;

public class LoginFragment extends Fragment implements LoginView {

    @SuppressWarnings("NullableProblems") // onCreate
    @NonNull
    private LoginPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appComponent(getActivity()).plus(new LoginFragmentModule()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        presenter.bindView(this, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        presenter.unbindView(this);
        super.onDestroyView();
    }

    @Override
    public void onRegistered() {
        Toast.makeText(getActivity(), "User registered successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailedToRegister(@NonNull Throwable error) {
        Toast.makeText(getActivity(), "Can't register. Error: " + error, Toast.LENGTH_SHORT).show();
    }

    @Module
    public static class LoginFragmentModule {

        @Provides
        @NonNull
        public LoginPresenter provideLoginPresenter(@NonNull LoginModel loginModel) {
            return new LoginPresenter(loginModel, create(io(), mainThread()));
        }
    }

    @Subcomponent(modules = LoginFragmentModule.class)
    public interface LoginFragmentComponent {

        void inject(@NonNull LoginFragment loginFragment);
    }
}
