package com.kermad.weather.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kermad.weather.Classes.WeatherDate;
import com.kermad.weather.R;

import java.util.ArrayList;

/**
 * Created by KERMAD_Mehdi on 09/04/2017.
 */

public class FiveDaysAdapter extends RecyclerView.Adapter<FiveDaysViewHolder> {

    public interface OnItemClickListener {
        void selectDate(WeatherDate wea);
    }

    private ArrayList<WeatherDate> list;
    private final OnItemClickListener listener;

    //ajouter un constructeur prenant en entrée une liste
    public FiveDaysAdapter(ArrayList<WeatherDate> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }


    @Override
    public FiveDaysViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_five_days, viewGroup,false);
        return new FiveDaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FiveDaysViewHolder myViewHolder, int position) {
        WeatherDate myObject = list.get(position);
        myViewHolder.bind(myObject, listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}