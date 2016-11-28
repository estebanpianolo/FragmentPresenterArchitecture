package com.example.etiennepinault.presenting.secondary;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.presenting.BaseFragmentPresenter;
import rx.subjects.BehaviorSubject;

public class SecondaryPresenter
        extends BaseFragmentPresenter<SecondaryView, SecondaryState> {

    private BehaviorSubject<Integer> counter = BehaviorSubject.create(0);

    public SecondaryPresenter(
            @NonNull SecondaryView view,
            @Nullable SecondaryState state) {
        super(view, state);
        if (state != null) {
            counter.onNext(state.getCount());
        }
        addSubscription(counter.subscribe(view::setCounter));
    }

    @Override protected SecondaryState saveState() {
        return new SecondaryState(counter.getValue());
    }

    @Override public void destroy() {

    }

    public void incrementCounter() {
        counter.onNext(counter.getValue() + 1);
    }

    public void decrementCounter() {
        counter.onNext(counter.getValue() - 1);
    }
}
