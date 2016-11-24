package com.example.etiennepinault.presenting.base;

import android.support.annotation.NonNull;

import java.lang.reflect.Constructor;

public abstract class BaseFragmentParentPresenter<V extends BaseView, P extends BaseParentPresenter>
        extends BaseFragmentPresenter<V> {

    @NonNull private P parentPresenter;

    public BaseFragmentParentPresenter(@NonNull V view, @NonNull P parentPresenter) {
        super(view);
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
                if (parameterTypes.length == 2) {
                    Class<?> presenterType = parameterTypes[0];
                    Class<?> parentPresenterType = parameterTypes[1];
                    if (BaseView.class.isAssignableFrom(presenterType)
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

        P build(BaseView view, BaseParentPresenter baseParentPresenter) {
            try {
                return (P) getConstructor(view).newInstance(view, baseParentPresenter);
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
