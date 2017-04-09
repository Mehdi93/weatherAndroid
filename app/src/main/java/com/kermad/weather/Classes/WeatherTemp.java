package com.kermad.weather.Classes;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class WeatherTemp {

    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

    public WeatherTemp() {
        this.day = 0;
        this.min = 0;
        this.night = 0;
        this.max = 0;
        this.eve = 0;
        this.morn = 0;
    }

    public WeatherTemp(double day, double min, double night, double max, double eve, double morn) {
        this.day = day;
        this.min = min;
        this.night = night;
        this.max = max;
        this.eve = eve;
        this.morn = morn;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }
}
