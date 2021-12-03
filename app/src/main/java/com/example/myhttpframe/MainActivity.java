package com.example.myhttpframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.myhttpframe.frame.IDataListener;
import com.example.myhttpframe.javaBean.RequestBean;
import com.example.myhttpframe.javaBean.ResponseBean;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


    }

    public void click(View view) {
        String url = "http://apis.juhe.cn/simpleWeather/query";
        RequestBean param = new RequestBean("2", "2567a9abe0a854aaaa92e0481365cf1c");
        MyFrame.sendJsonRequest(url, param, ResponseBean.class, new IDataListener<ResponseBean>() {
            @Override
            public void onSuccess(ResponseBean response) {
                Log.e(">>>>>>", "response " + response.toString());
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}