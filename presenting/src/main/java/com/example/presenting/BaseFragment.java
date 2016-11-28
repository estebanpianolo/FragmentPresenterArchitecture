package com.example.presenting;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class BaseFragment<P extends BaseFragmentPresenter> extends Fragment implements BaseView {

    private P presenter;

    private static final String TAG = "BaseFragment";

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BaseState baseState = null;
        if(savedInstanceState != null) {
            Object state = savedInstanceState.get("savedState_" + getClass().getName());
            if(state != null && state instanceof BaseState) {
                baseState = (BaseState) state;
            }
        }

        presenter = new BasePresenter.Factory<P>().build(this, baseState);
        Log.e(TAG, "onViewCreated: " + this + " " + savedInstanceState);
    }

    @Override public void onDestroyView() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroyView();
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
