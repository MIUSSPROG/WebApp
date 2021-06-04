package com.example.webapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.webapp.Model.Weather;
import com.example.webapp.R;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeatherDayAdapter extends RecyclerView.Adapter<WeatherDayAdapter.WeatherDayViewHolder>{

    List<Weather.Day> weatherDayList;
    Context context;

    public void setWeatherDayList(List<Weather.Day> weatherDayList) {
        this.weatherDayList = weatherDayList;
    }

    public WeatherDayAdapter(Context context) {
        this.context = context;
    }

    @Override
    public WeatherDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_daily_item, parent, false);
        return new WeatherDayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherDayAdapter.WeatherDayViewHolder holder, int position) {
        Weather.Day weatherDay = weatherDayList.get(position);
        Date date = new Date(TimeUnit.MILLISECONDS.convert(weatherDay.getDt(), TimeUnit.SECONDS));

        holder.tvMaxTemp.setText(String.valueOf((int)weatherDay.getTemp().getMax()) + " \u2103");
        holder.tvMinTemp.setText(String.valueOf((int)weatherDay.getTemp().getMin()) + " \u2103");

        String weekday = getWeekday(date.getDay());
        holder.tvWeekday.setText(weekday);

        String iconId = weatherDay.getWeather().get(0).getIcon();
        String imageURL = "http://openweathermap.org/img/wn/" + iconId + ".png";
        Glide.with(context).load(imageURL).into(holder.imgvIcon);
    }

    public String getWeekday(Integer day){
        switch (day){
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 0:
                return "Воскресенье";
            default:
                return "";
        }
    }

    @Override
    public int getItemCount() {
        if(weatherDayList != null) {
            return weatherDayList.size();
        }
        else
            return 0;
    }

    public class WeatherDayViewHolder extends RecyclerView.ViewHolder{

        TextView tvWeekday, tvMaxTemp, tvMinTemp;
        ImageView imgvIcon;

        public WeatherDayViewHolder(View itemView) {
            super(itemView);

            tvWeekday = itemView.findViewById(R.id.tvRvItemVerWeekday);
            tvMaxTemp = itemView.findViewById(R.id.tvRvItemVerTempDay);
            tvMinTemp = itemView.findViewById(R.id.tvRvItemVerTempNight);
            imgvIcon = itemView.findViewById(R.id.imgvRvItemVerIcon);
        }
    }
}
