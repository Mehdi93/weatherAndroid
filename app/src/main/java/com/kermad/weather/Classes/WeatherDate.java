package com.kermad.weather.Classes;

import java.util.ArrayList;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class WeatherDate {

    private long dt;
    private WeatherTemp temp;
    private ArrayList<WeatherInfo> weather;
    private double pressure;
    private int humidity;
    private double speed;
    private int deg;
    private int clouds;

    public WeatherDate() {
        this.dt = 0;
        this.pressure = 0;
        this.speed = 0;
        this.weather = new ArrayList<>();
        this.temp = new WeatherTemp();
        this.humidity = 0;
        this.deg = 0;
        this.clouds = 0;
    }

    public WeatherDate(long dt, double pressure, double speed, ArrayList<WeatherInfo> weather, WeatherTemp temp, int humidity, int deg, int clouds) {
        this.dt = dt;
        this.pressure = pressure;
        this.speed = speed;
        this.weather = weather;
        this.temp = temp;
        this.humidity = humidity;
        this.deg = deg;
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public WeatherTemp getTemp() {
        return temp;
    }

    public void setTemp(WeatherTemp temp) {
        this.temp = temp;
    }

    public ArrayList<WeatherInfo> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherInfo> weather) {
        this.weather = weather;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }
}
