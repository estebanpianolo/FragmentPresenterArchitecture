package com.example.etiennepinault.presenting.activity;

import com.example.etiennepinault.presenting.base.BaseView;
import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;

public interface MainView extends BaseView {

    SecondaryPresenter getSecondaryPresenter();
}
