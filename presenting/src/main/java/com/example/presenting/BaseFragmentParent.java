package com.example.presenting;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.View;

public class BaseFragmentParent<P extends BaseFragmentParentPresenter>
        extends Fragment
        implements BaseView {

    private P presenter;


    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Activity activity = getActivity();

        BaseParentPresenter baseParentPresenter = null;
        if(activity instanceof BaseActivity) {
            BasePresenter activityPresenter = ((BaseActivity) activity).getPresenter();
            if(activityPresenter instanceof BaseParentPresenter) {
                baseParentPresenter = (BaseParentPresenter) activityPresenter;
            }
        }
        BaseState baseState = null;
        if(savedInstanceState != null) {
            Object state = savedInstanceState.get("savedState_" + getClass().getName());
            if(state != null && state instanceof BaseState) {
                baseState = (BaseState) state;
            }
        }
        if(baseParentPresenter != null) {
            presenter = new BaseFragmentParentPresenter.
                    Factory<P>().build(this, baseState, baseParentPresenter);
        } else {
            throw new RuntimeException("Did you forget to add a Presenter as a genericType in your Fragment ?");
        }
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        P presenter = getPresenter();
        if(presenter != null) {
            outState.putSerializable("savedState_" + getClass().getName(), presenter.saveState());
        }
    }

    @Nullable public P getPresenter() {
        return presenter;
    }
}
