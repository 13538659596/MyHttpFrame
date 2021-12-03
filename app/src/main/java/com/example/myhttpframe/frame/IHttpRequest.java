package com.example.myhttpframe.frame;

/**
 * 框架请求的顶层接口
 */
public interface IHttpRequest {
    void setUrl(String url);
    void setParam(byte[] param);
    void setHttpListener(IHttpResponseListener iHttpResponseListener);
    void execute();
}
