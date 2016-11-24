package com.example.etiennepinault.presenting.activity;

import com.example.etiennepinault.presenting.base.BaseView;
import com.example.etiennepinault.presenting.primary.PrimaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryFragment;

public interface MainView extends BaseView {

    void changeMainPadding();

    void addPrimaryFragment(PrimaryFragment primaryFragment);

    void addSecondaryFragment(SecondaryFragment secondaryFragment);
}
