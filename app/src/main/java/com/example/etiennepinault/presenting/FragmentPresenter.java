package com.example.etiennepinault.presenting;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.base.BasePresenter;

public class FragmentPresenter
        extends BasePresenter<FragmentView> {

    public FragmentPresenter(@NonNull FragmentView view) {
        super(view);
        view.setBackGroundColorToRed();
    }

    @Override public void destroy() {

    }
}
