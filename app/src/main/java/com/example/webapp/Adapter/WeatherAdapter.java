package com.example.webapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webapp.Model.Weather;
import com.example.webapp.R;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    List<Weather.Hour> weatherList;

    public void setWeatherList(List<Weather.Hour> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_hour_item, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder( WeatherAdapter.WeatherViewHolder holder, int position) {
        Weather.Hour weatherHour = weatherList.get(position);
        holder.tvTemp.setText( String.valueOf(weatherHour.getTemp()) );
        Date date = new Date(TimeUnit.MILLISECONDS.convert(weatherHour.getDt(), TimeUnit.SECONDS));
        holder.tvTime.setText( String.valueOf(date.getHours()));
    }

    @Override
    public int getItemCount() {
        if(weatherList != null) {
            return weatherList.size();
        }
        else{
            return 0;
        }
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{

        TextView tvTime, tvTemp;
        ImageView imgvIcon;

        public WeatherViewHolder(View itemView) {
            super(itemView);

            tvTime = itemView.findViewById(R.id.tvRvHour);
            tvTemp = itemView.findViewById(R.id.tvRvTemp);
            imgvIcon = itemView.findViewById(R.id.imgvRvIcon);
        }
    }
}
