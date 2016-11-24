package com.example.etiennepinault.presenting.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.etiennepinault.presenting.R;
import com.example.etiennepinault.presenting.base.BaseActivity;
import com.example.etiennepinault.presenting.primary.PrimaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;
import com.example.etiennepinault.presenting.third.ThirdFragment;

public class MainActivity
        extends BaseActivity<MainPresenter>
        implements MainView {

    @BindView(R.id.secondary_content) ViewGroup secondaryContent;
    private SecondaryFragment secondaryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.setDebug(true);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PrimaryFragment primaryFragment = new PrimaryFragment();
        secondaryFragment = new SecondaryFragment();
        ThirdFragment thirdFragment = new ThirdFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.primary_content, primaryFragment);
        transaction.add(R.id.secondary_content, secondaryFragment);
        transaction.add(R.id.third_content, thirdFragment);
        transaction.commit();

    }

    @Override public SecondaryPresenter getSecondaryPresenter() {
        return secondaryFragment.getPresenter();
    }
}
