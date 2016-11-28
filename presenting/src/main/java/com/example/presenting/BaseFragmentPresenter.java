package com.example.presenting;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class BaseFragmentPresenter<V extends BaseView, S extends BaseState>
        extends BasePresenter<V, S> {

    public BaseFragmentPresenter(@NonNull V view, @Nullable S state) {
        super(view, state);
    }
}
