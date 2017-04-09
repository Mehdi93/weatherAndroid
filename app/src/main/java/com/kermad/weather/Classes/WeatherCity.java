package com.kermad.weather.Classes;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class WeatherCity {

    private int id;
    private String name;
    private WeatherCoord coord;
    private String country;
    private int population;

    public WeatherCity() {
        this.id = 0;
        this.name = "";
        this.coord = new WeatherCoord();
        this.country = "";
        this.population = 0;
    }

    public WeatherCity(int id, String name, WeatherCoord coord, String country, int population) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherCoord getCoord() {
        return coord;
    }

    public void setCoord(WeatherCoord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
