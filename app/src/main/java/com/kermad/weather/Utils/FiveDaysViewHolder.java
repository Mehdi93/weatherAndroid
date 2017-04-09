package com.kermad.weather.Utils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kermad.weather.Classes.WeatherDate;
import com.kermad.weather.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class FiveDaysViewHolder extends RecyclerView.ViewHolder {

    private ImageView iconImageView;
    private TextView dateText;
    private TextView descriptionText;
    private TextView tempText;

    //itemView est la vue correspondante à 1 cellule
    public FiveDaysViewHolder(View itemView) {
        super(itemView);

        iconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
        dateText = (TextView) itemView.findViewById(R.id.dateTextView);
        descriptionText = (TextView) itemView.findViewById(R.id.descriptionTextView);
        tempText = (TextView) itemView.findViewById(R.id.tempTextView);
    }

    public void bind(final WeatherDate date, final FiveDaysAdapter.OnItemClickListener listener){

        //on télécharge l'icone associée
        Picasso.with(itemView.getContext()).load("http://openweathermap.org/img/w/"+date.getWeather().get(0).getIcon()+".png")
                .into(iconImageView);

        //on convertit le timestamp en date puis l'affiche
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(date.getDt()*1000L); //conversion du format Unix vers Java

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy");
        dateText.setText(sdf.format(c.getTime()));

        descriptionText.setText(date.getWeather().get(0).getMain());
        tempText.setText(Math.round(date.getTemp().getDay())+"°C"); //on arrondi la température puis on l'affiche

        //au clique, on ouvre le Detail de la journée
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.selectDate(date);
            }
        });

    }


}