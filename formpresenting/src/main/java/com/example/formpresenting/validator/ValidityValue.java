package com.example.formpresenting.validator;

import java.io.Serializable;

/**
 * Created by etiennepinault on 29/09/2016.
 */
public class ValidityValue<R>
        implements Serializable {
    private boolean isValid;
    private R value;

    public ValidityValue(R value) {
        this.value = value;
    }

    public boolean isValid() {
        return isValid;
    }

    public R getValue() {
        return value;
    }

    public ValidityValue<R> setValidity(boolean valid) {
        isValid = valid;
        return this;
    }
}
