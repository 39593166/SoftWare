package com.utoo.werent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.utoo.werent.R;
import com.utoo.werent.ui.base.BaseActivity;
import com.utoo.werent.ui.presenter.LoginPresenter;
import com.utoo.werent.ui.view.LoginView;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this, this);
        findViews();
    }

    private EditText loginUserName;
    private EditText loginPassword;
    private Button loginSubmit;
    private Button resetPassword;
    private Button goRegist;

    private void findViews() {
        loginUserName = (EditText) findViewById(R.id.login_userName);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginSubmit = (Button) findViewById(R.id.login_submit);
        resetPassword = (Button) findViewById(R.id.reset_password);
        goRegist = (Button) findViewById(R.id.go_regist);

        loginSubmit.setOnClickListener(this);
        resetPassword.setOnClickListener(this);
        goRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == loginSubmit) {
            // Handle clicks for loginSubmit
            presenter.login();
        } else if (v == resetPassword) {
            // Handle clicks for resetPassword
        } else if (v == goRegist) {
            // Handle clicks for goRegist
            Intent intent = new Intent(this, RegistActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public String getUserName() {
        return loginUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return loginPassword.getText().toString().trim();
    }

    @Override
    public void loginSuc() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
