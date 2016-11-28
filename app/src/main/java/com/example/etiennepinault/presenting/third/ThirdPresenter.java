package com.example.etiennepinault.presenting.third;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.etiennepinault.presenting.activity.MainParentPresenter;
import com.example.presenting.BaseFragmentParentPresenter;
import com.example.presenting.BaseState;

public class ThirdPresenter
        extends BaseFragmentParentPresenter<ThirdView, BaseState, MainParentPresenter> {

    public ThirdPresenter(
            @NonNull ThirdView view,
            @Nullable BaseState state,
            @NonNull MainParentPresenter parentPresenter) {
        super(view, state, parentPresenter);
    }

    @Override protected BaseState saveState() {
        return null;
    }

    @Override protected void destroy() {

    }

    public void viewTouched() {
        getParentPresenter().thirdFragmentTouched();
    }
}
