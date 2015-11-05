package com.utoo.android.tools.net;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2015/10/27.
 */
public class AppHttpRequest {

    public static void sendHttp(RequestQueue mQueue, AppRequestParam request) {
        int method = request.getMethod();
        if (method == AppRequestParam.METHOD_GET) {
            get(mQueue, request.getURL(), request.getCallback());
        } else if (method == AppRequestParam.METHOD_POST) {
            post(mQueue, request.getURL(), request.getParams(), request.getCallback());
        }
    }

    protected static void get(RequestQueue mQueue, String url,
                              final AppHttpCallback callback) {

        StringRequest mStringRequest = new StringRequest(url,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e("请求结果:", response);
                        callback.onReturned(response);
                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("请求错误:" + error.toString());
                callback.NetFailed(error);
            }

        });
        mQueue.add(mStringRequest);

    }

    protected static void post(RequestQueue mQueue, String url,
                               JSONObject jsonObjectParams, final AppHttpCallback callback) {
        if (jsonObjectParams == null) {
            Log.e("requestParams", "null");
        } else {
            Log.e("requestParams", jsonObjectParams.toString());
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObjectParams,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onReturned(response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.NetFailed(error);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Connection", "Keep-Alive");
                return headers;
            }
        };
        mQueue.add(jsonObjectRequest);
    }

}
