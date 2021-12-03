package com.example.myhttpframe;

import com.example.myhttpframe.frame.HttpTask;
import com.example.myhttpframe.frame.IDataListener;
import com.example.myhttpframe.frame.ThreadManager;
import com.example.myhttpframe.realize.JsonHttpRequest;
import com.example.myhttpframe.realize.JsonResponseListener;

public class MyFrame {

    public static<T, M> void sendJsonRequest(String url, T requestParams, Class<M> response,
                                             IDataListener iDataListener) {
        JsonHttpRequest request = new JsonHttpRequest();
        JsonResponseListener listener = new JsonResponseListener(iDataListener,response);
        request.setHttpListener(listener);
        HttpTask httpTask = new HttpTask(url, requestParams, request, listener);
        ThreadManager.getInstance().addTask(httpTask);
    }
}
