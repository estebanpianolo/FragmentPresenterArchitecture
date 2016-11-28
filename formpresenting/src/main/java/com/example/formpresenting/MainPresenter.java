package com.example.formpresenting;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.formpresenting.validator.ValidityValue;
import com.example.presenting.BasePresenter;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class MainPresenter
        extends BasePresenter<MainView, MainState> {

    private BehaviorSubject<ValidityValue<String>> firstName = BehaviorSubject.create();
    private BehaviorSubject<ValidityValue<String>> lastName = BehaviorSubject.create();
    private BehaviorSubject<ValidityValue<String>> email = BehaviorSubject.create();
    private BehaviorSubject<ValidityValue<String>> phone = BehaviorSubject.create();
    private BehaviorSubject<ValidityValue<String>> pass = BehaviorSubject.create();
    private BehaviorSubject<ValidityValue<Boolean>> checked = BehaviorSubject.create();

    public MainPresenter(@NonNull MainView view, @Nullable MainState state) {
        super(view, state);
        view.setFirstName(state != null ? state.firstName : "");
        view.setLastName(state != null ? state.lastName : "");
        view.setEmail(state != null ? state.email : "");
        view.setPass(state != null ? state.pass : "");
        view.setPhone(state != null ? state.phone : "");
        view.setChecked(state != null ? state.checked : false);

        addSubscription(
                Observable.combineLatest(
                        firstName,
                        lastName,
                        email,
                        phone,
                        pass,
                        checked,
                        (fn, ln, e, ph, pa, c) ->
                                fn.isValid()
                                        && ln.isValid()
                                        && e.isValid()
                                        && ph.isValid()
                                        && pa.isValid()
                                        && c.isValid())
                          .subscribe(view::setSubmitButtonEnabled)
        );
    }

    @Override protected MainState saveState() {
        MainState mainState = new MainState();
        mainState.firstName = firstName.getValue().getValue();
        mainState.lastName = lastName.getValue().getValue();
        mainState.email = email.getValue().getValue();
        mainState.phone = phone.getValue().getValue();
        mainState.pass = pass.getValue().getValue();
        mainState.checked = checked.getValue().getValue();
        return mainState;
    }

    @Override protected void destroy() {

    }

    public void setFirstName(CharSequence text) {
        firstName.onNext(
                new ValidityValue<>(text.toString()).setValidity(text.toString().length() > 0));
    }

    public void setLastName(CharSequence text) {
        lastName.onNext(
                new ValidityValue<>(text.toString()).setValidity(text.toString().length() > 0));
    }

    public void setEmail(CharSequence text) {
        email.onNext(
                new ValidityValue<>(text.toString()).setValidity(text.toString().length() > 0));
    }

    public void setPhone(CharSequence text) {
        phone.onNext(
                new ValidityValue<>(text.toString()).setValidity(text.toString().length() > 0));
    }

    public void setPass(CharSequence text) {
        pass.onNext(
                new ValidityValue<>(text.toString()).setValidity(text.toString().length() > 0));
    }

    public void setChecked(boolean checked) {
        this.checked.onNext(new ValidityValue<>(checked).setValidity(checked));
    }
}
