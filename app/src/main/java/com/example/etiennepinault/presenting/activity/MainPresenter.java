package com.example.etiennepinault.presenting.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;
import com.example.presenting.BasePresenter;
import com.example.presenting.BaseState;

public class MainPresenter extends BasePresenter<MainView, BaseState>
        implements MainParentPresenter{

    public MainPresenter(@NonNull MainView view,
                         @Nullable BaseState state) {
        super(view, state);
    }

    @Override protected BaseState saveState() {
        return null;
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
