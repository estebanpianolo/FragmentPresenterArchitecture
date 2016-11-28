package com.example.presenting;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.Constructor;

public abstract class BaseFragmentParentPresenter<V extends BaseView, S extends BaseState, P extends BaseParentPresenter>
        extends BaseFragmentPresenter<V, S> {

    @NonNull private P parentPresenter;

    public BaseFragmentParentPresenter(@NonNull V view,
                                       @Nullable S state,
                                       @NonNull P parentPresenter) {
        super(view, state);
        this.parentPresenter = parentPresenter;
    }

    @NonNull protected P getParentPresenter() {
        return parentPresenter;
    }

    static class Factory<P extends BasePresenter>
            extends BasePresenter.Factory {

        private Constructor<?> getConstructor(BaseView view)
                throws ClassCastException {

            Constructor<?>[] constructors = getPresenterClass(view).getConstructors();
            Constructor<?> matchingConstructor = null;
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 3) {
                    Class<?> presenterType = parameterTypes[0];
                    Class<?> stateType = parameterTypes[1];
                    Class<?> parentPresenterType = parameterTypes[2];
                    if (BaseView.class.isAssignableFrom(presenterType)
                            && BaseState.class.isAssignableFrom(stateType)
                            && BaseParentPresenter.class.isAssignableFrom(parentPresenterType)) {
                        matchingConstructor = constructor;
                        break;
                    }
                }
            }
            if(matchingConstructor == null) {
                throw new RuntimeException("Did you forget to make your Fragment extending the BaseFragmentParent class ?");
            }
            return matchingConstructor;
        }

        P build(BaseView view, BaseState state, BaseParentPresenter baseParentPresenter) {
            try {
                return (P) getConstructor(view).newInstance(view, state, baseParentPresenter);
            } catch (ClassCastException e) {
                throw new RuntimeException(
                        "Did you forget to add a Presenter as a genericType in your Fragment ?",
                        e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(
                        "Did you forget to make your Fragment implementing the BaseView interface"
                                + " ?",
                        e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
