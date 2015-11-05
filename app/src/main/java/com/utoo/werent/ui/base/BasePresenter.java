package com.utoo.werent.ui.base;

import android.os.Handler;
import android.os.Message;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 2015/8/24.
 */
public class BasePresenter {
    /**
     * 线程工作内容接口
     */
    public interface ThreadRunCall {
        public void work();
    }

    public Handler handler;//

    /**
     * 激活Handler处理handlerMessage
     */
    public void initHandler(final HandlerDeal handlerDeal) {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                handlerDeal.messageDeal(msg);
                super.handleMessage(msg);
            }
        };
    }

    /**
     * handler处理Message接口
     */
    public interface HandlerDeal {
        public void messageDeal(Message msg);
    }

    /**
     * 开启线程
     *
     * @param msgId
     * @param call
     */
    public void runInThread(int msgId, final ThreadRunCall call) {
        new Thread() {
            @Override
            public void run() {
                call.work();
                super.run();
            }
        }.start();
    }

    public JSONObject getJson(String response) throws JSONException {
        JSONObject jo = new JSONObject(response);
        return jo;
    }
}
