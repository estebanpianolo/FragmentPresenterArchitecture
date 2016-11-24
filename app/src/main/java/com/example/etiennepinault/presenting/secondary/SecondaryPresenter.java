package com.example.etiennepinault.presenting.secondary;

import android.support.annotation.NonNull;

import com.example.etiennepinault.presenting.base.BaseFragmentPresenter;
import rx.subjects.BehaviorSubject;

public class SecondaryPresenter extends BaseFragmentPresenter<SecondaryView> {

    private BehaviorSubject<Integer> counter = BehaviorSubject.create(0);

    public SecondaryPresenter(@NonNull SecondaryView view) {
        super(view);

        addSubscription(counter.subscribe(view::setCounter));
    }

    @Override public void destroy() {

    }

    public void incrementCounter() {
        counter.onNext(counter.getValue()+1);
    }

    public void decrementCounter() {
        counter.onNext(counter.getValue()-1);
    }
}
