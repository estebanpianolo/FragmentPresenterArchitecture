package com.example.etiennepinault.presenting.activity;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.base.BasePresenter;
import com.example.etiennepinault.presenting.primary.PrimaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;

public class MainPresenter extends BasePresenter<MainView> implements MainParentPresenter{

    private final SecondaryFragment secondaryFragment;

    public MainPresenter(@NonNull MainView view) {
        super(view);

        PrimaryFragment primaryFragment = new PrimaryFragment();
        secondaryFragment = new SecondaryFragment();
        view.addPrimaryFragment(primaryFragment);
        view.addSecondaryFragment(secondaryFragment);
    }

    @Override public void destroy() {

    }

    @Override public void fragmentTouched() {
        SecondaryPresenter presenter = secondaryFragment.getPresenter();
        if(presenter != null) {
            presenter.incrementCounter();
        }
    }
}
