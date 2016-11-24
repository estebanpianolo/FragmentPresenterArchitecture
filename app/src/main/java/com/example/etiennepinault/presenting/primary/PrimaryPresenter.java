package com.example.etiennepinault.presenting.primary;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.activity.MainParentPresenter;
import com.example.etiennepinault.presenting.base.BaseFragmentParentPresenter;

public class PrimaryPresenter
        extends BaseFragmentParentPresenter<PrimaryView, MainParentPresenter> {

    public PrimaryPresenter(@NonNull PrimaryView view,
                            @NonNull MainParentPresenter parentPresenter) {
        super(view, parentPresenter);
        view.setBackGroundColorToRed();
    }

    @Override public void destroy() {

    }

    public void viewTouched() {
        getParentPresenter().fragmentTouched();
    }
}
