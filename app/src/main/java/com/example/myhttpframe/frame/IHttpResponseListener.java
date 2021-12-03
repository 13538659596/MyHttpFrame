package com.example.myhttpframe.frame;

import java.io.InputStream;

public interface IHttpResponseListener {

    void onSuccess(InputStream in);

    void onFailure(String msg);
}
