package com.example.etiennepinault.presenting.primary;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.etiennepinault.presenting.activity.MainParentPresenter;
import com.example.presenting.BaseFragmentParentPresenter;
import com.example.presenting.BaseState;

public class PrimaryPresenter
        extends BaseFragmentParentPresenter<PrimaryView, BaseState, MainParentPresenter> {

    public PrimaryPresenter(@NonNull PrimaryView view,
                            @Nullable BaseState state,
                            @NonNull
                                    MainParentPresenter parentPresenter) {
        super(view, state, parentPresenter);
        view.setBackGroundColorToRed();
    }

    @Override protected BaseState saveState() {
        return null;
    }

    @Override public void destroy() {

    }

    public void viewTouched() {
        getParentPresenter().fragmentTouched();
    }
}
