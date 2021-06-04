package com.example.webapp.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.webapp.Model.Weather;
import com.example.webapp.R;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeatherHourAdapter extends RecyclerView.Adapter<WeatherHourAdapter.WeatherViewHolder> {


    List<Weather.Hour> weatherHourList;
    Context context;
    Integer sunrise, sunset;

    public WeatherHourAdapter(Context context) {
        this.context = context;
    }

    public void setWeatherHourList(List<Weather.Hour> weatherHourList, Integer sunsrise, Integer sunset) {
        this.weatherHourList = weatherHourList;
        this.sunrise = sunsrise;
        this.sunset  = sunset;
    }


    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_hour_item, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherHourAdapter.WeatherViewHolder holder, int position) {
        Weather.Hour weatherHour = weatherHourList.get(position);

        Integer temperature = (int) weatherHour.getTemp();
        holder.tvTemp.setText(String.valueOf(temperature) + " \u2103");
        Date date = new Date(TimeUnit.MILLISECONDS.convert(weatherHour.getDt(), TimeUnit.SECONDS));

        if(position == 0){
            holder.tvTime.setText("сейчас");
        }

        Date dateSunrise = new Date(TimeUnit.MILLISECONDS.convert(sunrise, TimeUnit.SECONDS));
        Date dateSunset = new Date(TimeUnit.MILLISECONDS.convert(sunset, TimeUnit.SECONDS));

        if(date.getHours() == dateSunrise.getHours()){
            holder.imgvIcon.setImageResource(R.drawable.sunrize_set);
            holder.tvTime.setText("восход");
        }
        else if(date.getHours() == dateSunset.getHours()){
            holder.imgvIcon.setImageResource(R.drawable.sunrize_set);
            holder.tvTime.setText("закат");
        }
        else{
            holder.tvTime.setText(String.valueOf(date.getHours()));
            String iconId = weatherHour.getWeather().get(0).getIcon();
            String imageURL = "http://openweathermap.org/img/wn/" + iconId + ".png";
            Glide.with(context).load(imageURL).into(holder.imgvIcon);
        }

    }

    @Override
    public int getItemCount() {
        if(weatherHourList != null) {
            return weatherHourList.size();
        }
        else
            return 0;
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
