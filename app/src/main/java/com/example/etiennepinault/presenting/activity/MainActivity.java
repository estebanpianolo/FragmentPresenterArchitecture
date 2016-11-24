package com.example.etiennepinault.presenting.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.etiennepinault.presenting.R;
import com.example.etiennepinault.presenting.base.BaseActivity;
import com.example.etiennepinault.presenting.primary.PrimaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryFragment;

public class MainActivity
        extends BaseActivity<MainPresenter>
        implements MainView {

    @BindView(R.id.secondary_content) ViewGroup secondaryContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.setDebug(true);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override public void changeMainPadding() {
        ViewParent parent = this.findViewById(R.id.primary_content).getParent();
        ((View)parent).setPadding(150, 150, 150, 150);
    }

    @Override public void addPrimaryFragment(PrimaryFragment primaryFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.primary_content, primaryFragment);
        transaction.commit();
    }

    @Override public void addSecondaryFragment(SecondaryFragment secondaryFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.secondary_content, secondaryFragment);
        transaction.commit();

    }
}
