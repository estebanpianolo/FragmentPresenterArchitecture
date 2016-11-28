package com.example.formpresenting;

import com.example.presenting.BaseView;

public interface MainView
        extends BaseView {
    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmail(String email);

    void setPass(String pass);

    void setPhone(String phone);

    void setChecked(Boolean checked);

    void setSubmitButtonEnabled(boolean enabled);
}
