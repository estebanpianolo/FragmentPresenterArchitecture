package com.example.etiennepinault.presenting.base;

import android.support.annotation.NonNull;

public abstract class BaseFragmentPresenter<V extends BaseView>
        extends BasePresenter<V> {


    public BaseFragmentPresenter(@NonNull V view) {
        super(view);
    }
}
