package com.example.etiennepinault.presenting.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new BasePresenter.Factory<P>().build(this);
    }

    @Override protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    public @Nullable P getPresenter() {
        return presenter;
    }
}
