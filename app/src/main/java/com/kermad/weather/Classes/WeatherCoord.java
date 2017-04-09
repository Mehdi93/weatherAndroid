package com.kermad.weather.Classes;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class WeatherCoord {

    private double lon;
    private double lat;

    public WeatherCoord() {
        this.lon = 0;
        this.lat = 0;
    }

    public WeatherCoord(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
