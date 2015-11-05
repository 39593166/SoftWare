package com.utoo.werent.ui.view;

import com.utoo.werent.ui.base.BaseView;

/**
 * Created by Lenovo on 2015/10/27.
 */
public interface LoginView extends BaseView{
    public String getUserName();

    public String getPassword();

    public void loginSuc();
}
