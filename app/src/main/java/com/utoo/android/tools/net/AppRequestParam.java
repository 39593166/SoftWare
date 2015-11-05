package com.utoo.android.tools.net;

import org.json.JSONObject;

/**
 * Created by Lenovo on 2015/10/27.
 */
public interface AppRequestParam {
    public static final int METHOD_GET = 0x1;
    public static final int METHOD_POST = 0x2;

    public int getMethod();

    public JSONObject getParams();

    public String getURL();

    public AppHttpCallback getCallback();
}
