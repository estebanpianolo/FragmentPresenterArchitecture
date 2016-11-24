package com.example.etiennepinault.presenting.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class PresenterFactory<P extends BasePresenter> {

    @SuppressWarnings("unchecked")
    private Class<P> getPresenterClass(BaseView view)
            throws ClassCastException {

        Type type = view.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<P>) paramType.getActualTypeArguments()[0];
    }

    private Constructor<?> getConstructor(BaseView view) throws ClassCastException {
        Constructor<?>[] declaredConstructors = getPresenterClass(view).getConstructors();
        Constructor<?> constructor = null;
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            if (parameterTypes.length == 1) {
                Class<?> parameterType = parameterTypes[0];
                if (BaseView.class.isAssignableFrom(parameterType)) {
                    constructor = declaredConstructor;
                    break;
                }
            }
        }
        return constructor;
    }

    public P build(BaseView view) {
        try {
            return (P) getConstructor(view).newInstance(view);
        } catch (ClassCastException e) {
            throw new RuntimeException(
                    "Did you forget to add a Presenter as a genericType in your Activity ?",
                    e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(
                    "Did you forget to make your activity implementing the BaseView interface ?",
                    e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}