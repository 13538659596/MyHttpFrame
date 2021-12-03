package com.example.myhttpframe.frame;

import java.io.InputStream;

public interface IDataListener<T> {
    void onSuccess(T response);

    void onFailure(String msg);
}
