package com.example.presenting;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BasePresenter <V extends BaseView, S extends BaseState> {

    protected final @NonNull V view;

    private CompositeSubscription subscriptions = new CompositeSubscription();

    public BasePresenter(@NonNull V view, @Nullable S state) {
        this.view = view;
    }

    @SuppressWarnings({ "ConstantConditions", "unused" }) private BasePresenter() {view = null;}

    public void onDestroy() {
        destroy();
        clearSubscriptions();
    }

    abstract protected S saveState();

    protected abstract void destroy();

    protected Scheduler getIoThread() {
        return Schedulers.io();
    }

    protected Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }


    protected void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    protected void clearSubscriptions() {
        subscriptions.clear();
    }

    static class Factory<P extends BasePresenter> {

        @SuppressWarnings("unchecked")
        protected Class<P> getPresenterClass(BaseView view)
                throws ClassCastException {

            Type type = view.getClass().getGenericSuperclass();
            ParameterizedType paramType = (ParameterizedType) type;
            return (Class<P>) paramType.getActualTypeArguments()[0];
        }

        private Constructor<?> getConstructor(BaseView view) throws ClassCastException {
            Constructor<?>[] constructors = getPresenterClass(view).getConstructors();
            Constructor<?> matchingConstructor = null;
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 2) {
                    Class<?> parameterType = parameterTypes[0];
                    Class<?> stateType = parameterTypes[1];
                    if (BaseView.class.isAssignableFrom(parameterType)
                            && BaseState.class.isAssignableFrom(stateType)) {
                        matchingConstructor = constructor;
                        break;
                    }
                }
            }
            if(matchingConstructor == null) {
                throw new RuntimeException("Did you forget to make your Fragment extending the BaseFragment class ?");
            }
            return matchingConstructor;
        }

        public P build(BaseView view, BaseState state) {
            try {
                return (P) getConstructor(view).newInstance(view, state);
            } catch (ClassCastException e) {
                throw new RuntimeException(
                        "Did you forget to add a Presenter as a genericType in your Activity ?",
                        e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(
                        "Did you forget to make your Fragment implementing the BaseView interface ?",
                        e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
