package com.example.etiennepinault.presenting.secondary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.etiennepinault.presenting.R;
import com.example.presenting.BaseFragment;

import java.util.Locale;

public class SecondaryFragment extends BaseFragment<SecondaryPresenter>
        implements SecondaryView {

    @BindView(R.id.counter) TextView counterView;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.secondary_fragment, container, false);
        ButterKnife.bind(this, inflate);

        return inflate;
    }

    @Override public void setCounter(int count) {
        counterView.setText(String.format(Locale.US, "%d", count));
    }
}
