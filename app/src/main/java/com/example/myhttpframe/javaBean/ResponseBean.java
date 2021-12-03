package com.example.myhttpframe.javaBean;

import java.util.ArrayList;

public class ResponseBean {

   private String reason;
   private String error_code;
   private Result result;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "reason='" + reason + '\'' +
                ", error_code='" + error_code + '\'' +
                ", result=" + result +
                '}';
    }
}

class Result {
    private String city;
    private Realtime realtime;
    private ArrayList<Future> future;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }


    public ArrayList<Future> getFuture() {
        return future;
    }

    public void setFuture(ArrayList<Future> future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "Result{" +
                "city='" + city + '\'' +
                ", realtime=" + realtime +
                ", future=" + future +
                '}';
    }
}


class Future {
    private String date;
    private String temperature;
    private String weather;
    private String direct;
    private Wid wid;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public Wid getWid() {
        return wid;
    }

    public void setWid(Wid wid) {
        this.wid = wid;
    }

    @Override
    public String toString() {
        return "Future{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", direct='" + direct + '\'' +
                ", wid=" + wid +
                '}';
    }
}

class Wid {
    private String day;
    private String night;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "Wid{" +
                "day='" + day + '\'' +
                ", night='" + night + '\'' +
                '}';
    }
}

class Realtime {
    private String temperature;
    private String humidity;
    private String info;
    private String wid;
    private String direct;
    private String power;
    private String aqi;
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    @Override
    public String toString() {
        return "Realtime{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", info='" + info + '\'' +
                ", wid='" + wid + '\'' +
                ", direct='" + direct + '\'' +
                ", power='" + power + '\'' +
                ", aqi='" + aqi + '\'' +
                '}';
    }
}
