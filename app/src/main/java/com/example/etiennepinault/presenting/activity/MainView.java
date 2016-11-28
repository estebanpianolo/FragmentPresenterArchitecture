package com.example.etiennepinault.presenting.activity;

import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;
import com.example.presenting.BaseView;

public interface MainView extends BaseView {

    SecondaryPresenter getSecondaryPresenter();
}
