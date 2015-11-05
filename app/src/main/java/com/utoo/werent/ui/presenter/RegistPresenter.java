package com.utoo.werent.ui.presenter;

import android.content.Context;

import com.android.volley.VolleyError;
import com.utoo.android.tools.net.AppHttpCallback;
import com.utoo.android.tools.net.AppHttpRequest;
import com.utoo.android.tools.net.AppRequestParam;
import com.utoo.werent.ui.base.BasePresenter;
import com.utoo.werent.ui.util.MyRequestParam;
import com.utoo.werent.ui.util.RequestQueueFactory;
import com.utoo.werent.ui.view.RegistView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 2015/10/29.
 */
public class RegistPresenter extends BasePresenter {
    Context context;
    RegistView view;

    public RegistPresenter(Context context, RegistView view) {
        this.context = context;
        this.view = view;
    }

    public void regist() {
        String userName = view.getUserName();
        String pd1 = view.getPassword1();
        String pd2 = view.getPassword2();
        MyRequestParam param = new MyRequestParam(10001, AppRequestParam.METHOD_POST, new AppHttpCallback() {
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
                        view.registSuc();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        param.putBusinessparam("userName", userName);
        param.putBusinessparam("password", pd1);
        if (checkInput(userName, pd1, pd2)) {
            AppHttpRequest.sendHttp(RequestQueueFactory.getInstance(context), param);
        }
    }

    private boolean checkInput(String username, String pd1, String pd2) {
        if (username == null || username.length() < 6 || username.length() > 15) {
            view.toastMessage("请输入6-15位的用户名");
            return false;
        } else if (pd1 == null || pd1.length() < 6 || pd1.length() > 15) {
            view.toastMessage("请输入6-15位的密码");
            return false;
        } else if (!pd1.equals(pd2)) {
            view.toastMessage("两次密码输入不一致");
            return false;
        }
        return true;
    }
}
