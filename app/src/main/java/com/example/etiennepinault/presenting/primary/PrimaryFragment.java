package com.example.etiennepinault.presenting.primary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.presenting.BaseFragmentParent;

public class PrimaryFragment
        extends BaseFragmentParent<PrimaryPresenter>
        implements PrimaryView {

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = new View(container.getContext());
        view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                          ViewGroup.LayoutParams.MATCH_PARENT));
        view.setOnClickListener(v -> {
            if (getPresenter() != null) {
                getPresenter().viewTouched();
            }
        });
        return view;
    }

    @Override public void setBackGroundColorToRed() {
        getView().setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
    }
}
