package com.example.etiennepinault.presenting;

import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.etiennepinault.presenting.base.BaseActivity;

public class MainActivity
        extends BaseActivity<MainPresenter>
        implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override protected void onResume() {
        super.onResume();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.content_container, new MainFragment());
        transaction.commit();

    }
}
