package com.example.etiennepinault.presenting.base;

import android.support.annotation.NonNull;

public abstract class BasePresenter <V extends BaseView> {

    protected final @NonNull V view;

    public BasePresenter(@NonNull V view) {
        this.view = view;
    }

    @SuppressWarnings({ "ConstantConditions", "unused" }) private BasePresenter() {view = null;}

    public abstract void destroy();
}
