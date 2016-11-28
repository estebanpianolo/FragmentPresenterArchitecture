package com.example.presenting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseState baseState = null;
        if(savedInstanceState != null) {
            Object state = savedInstanceState.get("savedState_" + getClass().getName());
            if(state != null && state instanceof BaseState) {
                baseState = (BaseState) state;
            }
        }

        presenter = new BasePresenter.Factory<P>().build(this, baseState);
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        P presenter = getPresenter();
        if(presenter != null) {
            outState.putSerializable("savedState_" + getClass().getName(), presenter.saveState());
        }
    }

    public @Nullable P getPresenter() {
        return presenter;
    }
}
