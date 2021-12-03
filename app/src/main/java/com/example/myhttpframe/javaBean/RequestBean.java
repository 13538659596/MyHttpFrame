package com.example.myhttpframe.javaBean;

public class RequestBean {

    private String city;

    private String key;

    public RequestBean(String city, String key) {
        this.city = city;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
