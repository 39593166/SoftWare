package com.utoo.werent.ui.presenter;

import android.content.Context;

import com.android.volley.VolleyError;
import com.utoo.android.tools.net.AppHttpCallback;
import com.utoo.android.tools.net.AppHttpRequest;
import com.utoo.android.tools.net.AppRequestParam;
import com.utoo.werent.ui.base.BasePresenter;
import com.utoo.werent.ui.util.MyRequestParam;
import com.utoo.werent.ui.util.RequestQueueFactory;
import com.utoo.werent.ui.view.LoginView;

import org.json.JSONException;
import org.json.JSONObject;
public class LoginPresenter extends BasePresenter {
    Context context;
    LoginView view;

    public LoginPresenter(Context context, LoginView view) {
        this.context = context;
        this.view = view;
    }

    public void login() {
        String userName = view.getUserName();
        String password = view.getPassword();
        MyRequestParam param = new MyRequestParam(10002, AppRequestParam.METHOD_POST, new AppHttpCallback() {
            @Override
            public void NetFailed(VolleyError error) {
                view.toastMessage("网络连接错误");
            }

            @Override
            public void onReturned(String response) {
                try {
                    JSONObject jsonObject = getJson(response);
                    int state = jsonObject.getInt("state");
                    String msg = jsonObject.getString("msg");
                    if (state == 0) {
                        view.toastMessage(msg);
                    } else {
                        view.toastMessage("注册成功");
                        view.loginSuc();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        param.putBusinessparam("userName", userName);
        param.putBusinessparam("password", password);
        checkInput(userName, password);
        AppHttpRequest.sendHttp(RequestQueueFactory.getInstance(context), param);
    }

    private boolean checkInput(String username, String password) {
        if (username == null || username.length() < 6 || username.length() > 15) {
            view.toastMessage("请输入正确的用户名");
            return false;
        } else if (password == null || password.length() < 6 || password.length() > 15) {
            view.toastMessage("请输入正确的密码");
            return false;
        }
        return true;
    }
}
