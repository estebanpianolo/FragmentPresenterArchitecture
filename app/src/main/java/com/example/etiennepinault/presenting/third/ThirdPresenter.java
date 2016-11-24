package com.example.etiennepinault.presenting.third;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.activity.MainParentPresenter;
import com.example.etiennepinault.presenting.base.BaseFragmentParentPresenter;

public class ThirdPresenter extends BaseFragmentParentPresenter<ThirdView, MainParentPresenter> {
    public ThirdPresenter(
            @NonNull ThirdView view,
            @NonNull MainParentPresenter parentPresenter) {
        super(view, parentPresenter);
    }

    @Override protected void destroy() {

    }

    public void viewTouched() {
        getParentPresenter().thirdFragmentTouched();
    }

}
