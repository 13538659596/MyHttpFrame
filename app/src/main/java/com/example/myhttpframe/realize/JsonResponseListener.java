package com.example.myhttpframe.realize;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.myhttpframe.frame.IDataListener;
import com.example.myhttpframe.frame.IHttpResponseListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonResponseListener<T> implements IHttpResponseListener {

    private IDataListener iDataListener;
    private Class<T> response;

    public JsonResponseListener(IDataListener iDataListener, Class<T> response) {
        this.iDataListener = iDataListener;
        this.response = response;
    }

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public void onSuccess(InputStream in) {
        //获取服务器返回的结果
        String content = getContent(in);
        Log.e(">>>>>>>", " content " + content);
        T responseObject = JSON.parseObject(content, response);

        handler.post(new Runnable() {
            @Override
            public void run() {
                iDataListener.onSuccess(responseObject);
            }
        });

    }

    private String getContent(InputStream in) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bufferedReader.readLine())!= null) {
                sb.append(line + "\n");
            }
        }catch (IOException e) {

        }finally {
            try {
                in.close();
            }catch (IOException e) {

            }
        }

        return sb.toString().replace("\n", "");
    }

    @Override
    public void onFailure(String msg) {

    }


}
