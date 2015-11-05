package com.utoo.werent.ui.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Lenovo on 2015/10/29.
 */
public class RequestQueueFactory {
    private static RequestQueue mQueue;

    private RequestQueueFactory() {
    }

    public static RequestQueue getInstance(Context context) {
        if (mQueue == null) {
            mQueue = Volley.newRequestQueue(context);
        }
        return mQueue;
    }
}
