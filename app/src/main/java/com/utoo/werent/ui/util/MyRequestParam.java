package com.utoo.werent.ui.util;

import com.google.gson.Gson;
import com.utoo.android.tools.net.AppHttpCallback;
import com.utoo.android.tools.net.AppRequestParam;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fsm on 2015/10/27.
 */
public class MyRequestParam implements AppRequestParam {
    private int method = -1;
    private JSONObject jsonObject;
    private AppHttpCallback callback;
    private JSONObject param;

    public MyRequestParam(int actionCode, int method, AppHttpCallback callback) {
        this.callback = callback;
        this.method = method;
        jsonObject = new JSONObject();
        try {
            jsonObject.put("actionCode", actionCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 业务参数通过该方法放入
     * @param key
     * @param obj
     */
    public void putBusinessparam(String key, Object obj) {
        if (param == null) {
            param = new JSONObject();
        }
        try {
            Gson gson = new Gson();
            JSONObject jo = new JSONObject(gson.toJson(obj));
            param.put(key, jo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMethod() {
        return method;
    }

    @Override
    public JSONObject getParams() {
        try {
            jsonObject.put("param",param);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return param;
    }

    @Override
    public String getURL() {
        return AppConfig.AppHost;
    }

    @Override
    public AppHttpCallback getCallback() {
        return callback;
    }

}
