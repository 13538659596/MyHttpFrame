package com.example.myhttpframe.frame;

import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;

public class HttpTask<T> implements Runnable{
    private IHttpRequest request;
    private IHttpResponseListener listener;

    public HttpTask(String url, T paramData, IHttpRequest iHttpRequest, IHttpResponseListener listener) {
        this.request = iHttpRequest;
        this.listener = listener;
        request.setHttpListener(this.listener);
        request.setUrl(url);
        if(paramData != null) {
            String dataStr = JSON.toJSONString(paramData);
            Log.e(">>>>>>>", "dataStr " + dataStr);
            request.setParam(dataStr.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public void run() {
        request.execute();
    }


}
