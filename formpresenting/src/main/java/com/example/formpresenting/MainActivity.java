package com.example.formpresenting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnTextChanged;

import com.example.presenting.BaseActivity;

public class MainActivity
        extends BaseActivity<MainPresenter> implements MainView{

    @BindView(R.id.firstName) EditText firstNameView;
    @BindView(R.id.lastName) EditText lastNameView;
    @BindView(R.id.email) EditText emailView;
    @BindView(R.id.phone) EditText phoneView;
    @BindView(R.id.pass) EditText passView;
    @BindView(R.id.checkBox) CheckBox checkBox;
    @BindView(R.id.submit) Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
    }

    @OnTextChanged(R.id.firstName) public void firstNameChanged(CharSequence text) {
        MainPresenter presenter = getPresenter();
        if(presenter != null) {
            presenter.setFirstName(text);
        }
    }

    @OnTextChanged(R.id.lastName) void lastNameChanged(CharSequence text) {
        MainPresenter presenter = getPresenter();
        if(presenter != null) {
            presenter.setLastName(text);
        }
    }

    @OnTextChanged(R.id.email) void emailChanged(CharSequence text) {
        MainPresenter presenter = getPresenter();
        if(presenter != null) {
            presenter.setEmail(text);
        }
    }

    @OnTextChanged(R.id.phone) void phoneChanged(CharSequence text) {
        MainPresenter presenter = getPresenter();
        if(presenter != null) {
            presenter.setPhone(text);
        }
    }

    @OnTextChanged(R.id.pass) void passChanged(CharSequence text) {
        MainPresenter presenter = getPresenter();
        if(presenter != null) {
            presenter.setPass(text);
        }
    }

    @OnCheckedChanged(R.id.checkBox) void checkedChanged(boolean checked) {
        MainPresenter presenter = getPresenter();
        if(presenter != null) {
            presenter.setChecked(checked);
        }
    }

    @Override public void setFirstName(String firstName) {
        firstNameView.setText(firstName);
    }

    @Override public void setLastName(String lastName) {
        lastNameView.setText(lastName);
    }

    @Override public void setEmail(String email) {
        emailView.setText(email);
    }

    @Override public void setPass(String pass) {
        passView.setText(pass);
    }

    @Override public void setPhone(String phone) {
        phoneView.setText(phone);
    }

    @Override public void setChecked(Boolean checked) {
        checkBox.setEnabled(checked);
    }

    @Override public void setSubmitButtonEnabled(boolean enabled) {
        submit.setEnabled(enabled);
    }
}
