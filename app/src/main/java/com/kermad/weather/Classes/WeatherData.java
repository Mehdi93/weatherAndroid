package com.kermad.weather.Classes;


import java.util.ArrayList;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class WeatherData {

    private WeatherCity city;
    private int cod;
    private double message;
    private int cnt;
    private ArrayList<WeatherDate> list;

    public WeatherData() {
        this.city = new WeatherCity();
        this.cod = 0;
        this.message = 0;
        this.cnt = 0;
        this.list = new ArrayList<>();
    }

    public WeatherData(WeatherCity city, int cod, double message, int cnt, ArrayList<WeatherDate> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public WeatherCity getCity() {
        return city;
    }

    public void setCity(WeatherCity city) {
        this.city = city;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<WeatherDate> getList() {
        return list;
    }

    public void setList(ArrayList<WeatherDate> list) {
        this.list = list;
    }
}
