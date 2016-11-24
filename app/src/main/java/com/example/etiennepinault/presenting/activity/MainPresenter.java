package com.example.etiennepinault.presenting.activity;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.base.BasePresenter;
import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;

public class MainPresenter extends BasePresenter<MainView> implements MainParentPresenter{

    public MainPresenter(@NonNull MainView view) {
        super(view);
    }

    @Override public void destroy() {

    }

    @Override public void fragmentTouched() {
        SecondaryPresenter presenter = view.getSecondaryPresenter();
        if(presenter != null) {
            presenter.incrementCounter();
        }
    }

    @Override public void thirdFragmentTouched() {
        SecondaryPresenter presenter = view.getSecondaryPresenter();
        if(presenter != null) {
            presenter.decrementCounter();
        }
    }
}
