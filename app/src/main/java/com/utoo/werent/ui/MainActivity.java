package com.utoo.werent.ui;

import android.os.Bundle;

import com.utoo.werent.R;
import com.utoo.werent.ui.base.BaseActivity;
import com.utoo.werent.ui.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setPersonalTotel(float myCost, float mycount) {

    }

    @Override
    public void setGroupCostInfo() {

    }
}
