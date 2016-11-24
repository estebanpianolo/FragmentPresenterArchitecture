package com.example.etiennepinault.presenting.base;

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
        if(baseParentPresenter != null) {
            presenter = new BaseFragmentParentPresenter.
                    Factory<P>().build(this, baseParentPresenter);
        } else {
            throw new RuntimeException("Did you forget to add a Presenter as a genericType in your Fragment ?");
        }
    }

    @Nullable public P getPresenter() {
        return presenter;
    }
}
