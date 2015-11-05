package com.utoo.werent.ui.view;

import com.utoo.werent.ui.base.BaseView;

/**
 * Created by Lenovo on 2015/10/29.
 */
public interface RegistView extends BaseView {
    public String getUserName();

    public String getPassword1();

    public String getPassword2();

    public void registSuc();
}
