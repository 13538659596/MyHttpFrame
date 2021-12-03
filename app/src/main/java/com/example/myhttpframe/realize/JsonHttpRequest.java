package com.example.myhttpframe.realize;

import com.example.myhttpframe.frame.IHttpResponseListener;
import com.example.myhttpframe.frame.IHttpRequest;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JsonHttpRequest implements IHttpRequest {

    private String url;
    private byte[] param;
    private IHttpResponseListener iHttpResponseListener;
    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setParam(byte[] param) {
        this.param = param;
    }

    @Override
    public void setHttpListener(IHttpResponseListener iHttpResponseListener) {
        this.iHttpResponseListener = iHttpResponseListener;
    }

    @Override
    public void execute() {
        URL url = null;
        try {
            url = new URL(this.url);
            HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();// 此处的urlConnection对象实际上是根据URL的
            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("POST");

           // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
          // http正文内，因此需要设为true, 默认情况下是false;
            httpUrlConnection.setDoOutput(true);

            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpUrlConnection.setDoInput(true);

            // Post 请求不能使用缓存
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setConnectTimeout(60 * 1000);
            httpUrlConnection.setReadTimeout(60 * 1000);
            //httpUrlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");//设置参数类型是json格式
            httpUrlConnection.connect();

            String data = "key=2567a9abe0a854aaaa92e0481365cf1c&city=2";
            OutputStream out = httpUrlConnection.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            bos.write(data.getBytes(StandardCharsets.UTF_8));
            //刷新缓存，很重要，否则可能导致参数为空
            bos.flush();
            bos.close();

            /*StringBuffer sb=new StringBuffer();
            sb.append("key=");
            sb.append("2567a9abe0a854aaaa92e0481365cf1c&");
            sb.append("city=");
            sb.append("2");
            String param=sb.toString();
            OutputStream outputStream = httpUrlConnection.getOutputStream();
            outputStream.write(param.getBytes());
            outputStream.flush();
            outputStream.close();*/

            if(httpUrlConnection.getResponseCode() ==HttpURLConnection.HTTP_OK) {
                InputStream in = httpUrlConnection.getInputStream();
                iHttpResponseListener.onSuccess(in);
            }else {
                iHttpResponseListener.onFailure(httpUrlConnection.getResponseCode() + "");
            }
            httpUrlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }



    }
}
