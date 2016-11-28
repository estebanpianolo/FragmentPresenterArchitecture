package com.example.etiennepinault.presenting.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.etiennepinault.presenting.R;
import com.example.etiennepinault.presenting.primary.PrimaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryFragment;
import com.example.etiennepinault.presenting.secondary.SecondaryPresenter;
import com.example.etiennepinault.presenting.third.ThirdFragment;
import com.example.presenting.BaseActivity;

public class MainActivity
        extends BaseActivity<MainPresenter>
        implements MainView {

    private static final String TAG = "MainActivity";
    @BindView(R.id.secondary_content) ViewGroup secondaryContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.setDebug(true);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.e(TAG, "onCreate: " + savedInstanceState);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.primary_content, new PrimaryFragment());
            transaction.add(R.id.secondary_content, new SecondaryFragment(), SecondaryFragment.class.getName());
            transaction.add(R.id.third_content, new ThirdFragment());
            transaction.commit();
        }
    }

    @Override public SecondaryPresenter getSecondaryPresenter() {
        SecondaryFragment fragment = (SecondaryFragment) getFragmentManager().findFragmentByTag(SecondaryFragment.class.getName());
        return fragment.getPresenter();
    }
}
