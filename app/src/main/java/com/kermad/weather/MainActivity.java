package com.kermad.weather;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kermad.weather.Classes.WeatherData;
import com.kermad.weather.Classes.WeatherDate;
import com.kermad.weather.Utils.FiveDaysAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class MainActivity extends AppCompatActivity {

    private WeatherData weatherData;
    private ArrayList<WeatherDate> weatherDates;
    private RecyclerView fiveDaysRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeRefresh;
    private RequestQueue mRequestQueue;
    private Gson gson;
    private static String API_KEY = "8194ea842a9aef80a798c8ac0c320ec4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherData = new WeatherData();
        gson = new Gson();
        fiveDaysRecycler = (RecyclerView)findViewById(R.id.fiveDaysRecycler);
        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        weatherDates = weatherData.getList();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        fiveDaysRecycler.setHasFixedSize(true);

        //on affiche les datas en ligne
        mLayoutManager = new LinearLayoutManager(this);
        fiveDaysRecycler.setLayoutManager(mLayoutManager);

        //création de l'adapter + transmission des datas
        mAdapter = new FiveDaysAdapter(weatherDates, new FiveDaysAdapter.OnItemClickListener(){

            @Override
            public void selectDate(WeatherDate wea) {

                //on ouvre le Détail de la journée
                Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
                myIntent.putExtra("weatherDate", gson.toJson(wea));
                startActivity(myIntent);
            }
        });
        fiveDaysRecycler.setAdapter(mAdapter);

        //layout de rafraichissement des datas (tirer pour actualiser)
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //appel de l'API
                volley("http://api.openweathermap.org/data/2.5/forecast/daily?q=Paris&units=metric&cnt=5&appid="+API_KEY,
                        "fiveDaysWeather");
            }
        });

        //appel de l'API
        volley("http://api.openweathermap.org/data/2.5/forecast/daily?q=Paris&units=metric&cnt=5&appid="+API_KEY,
                "fiveDaysWeather");
    }

    public void volley(final String url, final String methode){

        if(isNetworkAvailable()) {
            // Instantiate the RequestQueue.
            RequestQueue queue = getRequestQueue();

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    switch (methode) {
                        case "fiveDaysWeather":

                            //on désérialise les datas recues en JSON
                            weatherData = gson.fromJson(response, WeatherData.class);

                            //actualisation des datas pour le recyclerView
                            weatherDates.clear();
                            weatherDates.addAll(weatherData.getList());
                            fiveDaysRecycler.getAdapter().notifyDataSetChanged();

                            swipeRefresh.setRefreshing(false);

                            break;
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("KERMAD", "Erreur : "+methode);
                    Log.e("KERMAD", error.toString());
                }
            })

            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }
            };

            // Add the request to the RequestQueue.
            stringRequest.setTag("MainActivity"); //on met un tag par défaut
            queue.add(stringRequest);
        }
        else {
            toast("Veuillez vous connecter à Internet");
        }
    }

    private void toast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private RequestQueue getRequestQueue() {

        //singleton du RequestQueue
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }
}
