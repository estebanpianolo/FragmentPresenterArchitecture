package com.example.etiennepinault.presenting.secondary;

import com.example.presenting.BaseState;

public class SecondaryState
        extends BaseState {

    private int count;

    public SecondaryState(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
