package com.example.etiennepinault.presenting;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(@NonNull MainView view) {
        super(view);
    }

    @Override public void destroy() {

    }
}
