package com.kermad.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kermad.weather.Classes.WeatherDate;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class DetailActivity extends AppCompatActivity {

    private WeatherDate weatherDate;
    private Intent intent;
    private Gson gson;
    private ImageView iconImageView;
    private TextView dateTextView;
    private TextView descriptionTextView;
    private TextView tempTextView;
    private TextView pressureTextView;
    private TextView humidityTextView;
    private TextView speedTextView;
    private TextView degTextView;
    private TextView mornTextView;
    private TextView dayTextView;
    private TextView eveTextView;
    private TextView nightTextView;
    private TextView minTextView;
    private TextView maxTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        gson = new Gson();
        intent = getIntent();
        weatherDate = gson.fromJson(getIntent().getStringExtra("weatherDate"), WeatherDate.class);

        iconImageView = (ImageView) findViewById(R.id.iconImageView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        tempTextView = (TextView) findViewById(R.id.tempTextView);
        pressureTextView = (TextView) findViewById(R.id.pressureTextView);
        humidityTextView = (TextView) findViewById(R.id.humidityTextView);
        speedTextView = (TextView) findViewById(R.id.speedTextView);
        degTextView = (TextView) findViewById(R.id.degTextView);
        mornTextView = (TextView) findViewById(R.id.mornTextView);
        dayTextView = (TextView) findViewById(R.id.dayTextView);
        eveTextView = (TextView) findViewById(R.id.eveTextView);
        nightTextView = (TextView) findViewById(R.id.nightTextView);
        minTextView = (TextView) findViewById(R.id.minTextView);
        maxTextView = (TextView) findViewById(R.id.maxTextView);


        //on télécharge l'icone associée
        Picasso.with(this)
               .load("http://openweathermap.org/img/w/"+weatherDate.getWeather().get(0).getIcon()+".png")
               .into(iconImageView);

        //on convertit le timestamp en date puis l'affiche
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(weatherDate.getDt()*1000L); //conversion du format Unix vers Java

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy");
        dateTextView.setText(sdf.format(c.getTime()));

        //on arrondi les températures avant de les afficher
        tempTextView.setText(Math.round(weatherDate.getTemp().getDay())+"°C");
        mornTextView.setText(Math.round(weatherDate.getTemp().getMorn())+"°C");
        dayTextView.setText(Math.round(weatherDate.getTemp().getDay())+"°C");
        eveTextView.setText(Math.round(weatherDate.getTemp().getEve())+"°C");
        nightTextView.setText(Math.round(weatherDate.getTemp().getNight())+"°C");
        minTextView.setText(Math.round(weatherDate.getTemp().getMin())+"°C");
        maxTextView.setText(Math.round(weatherDate.getTemp().getMax())+"°C");


        //on affiche le reste des données
        descriptionTextView.setText(weatherDate.getWeather().get(0).getMain());
        pressureTextView.setText(weatherDate.getPressure()+" hPa");
        humidityTextView.setText(weatherDate.getHumidity()+"%");
        speedTextView.setText(weatherDate.getSpeed()+" km/h");
        degTextView.setText(weatherDate.getDeg()+"°");

    }
}
