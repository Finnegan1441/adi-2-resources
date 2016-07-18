package com.example.hollis.gson_example.WeatherObjectClasses;

/**
 * Created by patrickcummins on 7/18/16.
 */

public class Condition {
    private int code, temp;
    private String date, text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
