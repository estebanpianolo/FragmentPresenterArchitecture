package com.example.etiennepinault.presenting.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class BaseFragment<P extends BaseFragmentPresenter> extends Fragment implements BaseView {

    private P presenter;

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new BasePresenter.Factory<P>().build(this);
    }

    @Override public void onDestroyView() {
        presenter.destroy();
        presenter = null;
        super.onDestroyView();
    }

    public @Nullable P getPresenter() {
        return presenter;
    }
}
