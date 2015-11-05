package com.utoo.werent.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.utoo.werent.R;
import com.utoo.werent.ui.base.BaseActivity;
import com.utoo.werent.ui.presenter.RegistPresenter;
import com.utoo.werent.ui.view.RegistView;

public class RegistActivity extends BaseActivity implements RegistView, View.OnClickListener {
    RegistPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        presenter = new RegistPresenter(this, this);
        findViews();
    }

    private EditText registUserName;
    private EditText registPassword1;
    private EditText registPassword2;
    private Button registSubmit;

    private void findViews() {
        registUserName = (EditText) findViewById(R.id.regist_userName);
        registPassword1 = (EditText) findViewById(R.id.regist_password1);
        registPassword2 = (EditText) findViewById(R.id.regist_password2);
        registSubmit = (Button) findViewById(R.id.regist_submit);

        registSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == registSubmit) {
            presenter.regist();
        }
    }


    @Override
    public String getUserName() {
        return registUserName.getText().toString().trim();
    }

    @Override
    public String getPassword1() {
        return registPassword1.getText().toString().trim();
    }

    @Override
    public String getPassword2() {
        return registPassword2.getText().toString().trim();
    }

    @Override
    public void registSuc() {
        this.finish();
    }
}
