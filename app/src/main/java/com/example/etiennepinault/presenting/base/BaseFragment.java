package com.example.etiennepinault.presenting.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.View;

public class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    private P presenter;

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new PresenterFactory<P>().build(this);
    }

    @Override public void onDestroyView() {
        presenter.destroy();
        presenter = null;
        super.onDestroyView();
    }

    public @NonNull P getPresenter() {
        return presenter;
    }

}
