package com.utoo.werent.ui.presenter;

import android.content.Context;

import com.utoo.werent.ui.base.BasePresenter;
import com.utoo.werent.ui.view.MainView;

/**
 * Created by Lenovo on 2015/10/30.
 */
public class MainPresenter extends BasePresenter {

    Context context;
    MainView view;

    public MainPresenter(Context context, MainView view) {
        this.context = context;
        this.view = view;
    }

    public void getMainData() {

    }
}
