package com.example.webapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.webapp.Adapter.WeatherDayAdapter;
import com.example.webapp.Adapter.WeatherHourAdapter;
import com.example.webapp.Model.Weather;
import com.example.webapp.Network.ApiClient;
import com.example.webapp.Network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CityFragment extends Fragment {

    TextView tvCityName;
    ImageView imgvCurrentIcon;
    RecyclerView rvHour, rvDay;
    WeatherHourAdapter adapterHour;
    WeatherDayAdapter adapterDay;
    Double lat, lon;

    public CityFragment(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);

        tvCityName = view.findViewById(R.id.tvCityName);
        imgvCurrentIcon = view.findViewById(R.id.imgvWeatherIcon);
        rvHour = view.findViewById(R.id.rvHour);
        rvDay = view.findViewById(R.id.rvDay);
        adapterHour = new WeatherHourAdapter(getContext());
        adapterDay = new WeatherDayAdapter(getContext());
        rvHour.setAdapter(adapterHour);
        rvDay.setAdapter(adapterDay);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Weather> call =  apiService.getWeatherInfo(lat, lon, "minutely", getString(R.string.apiKey), "metric", "ru");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                tvCityName.setText(weather.getTimezone());
                String iconId = weather.getCurrent().getWeather().get(0).getIcon();
                String imageURL = "http://openweathermap.org/img/wn/" + iconId + ".png";
                Glide.with(getContext()).load(imageURL).into(imgvCurrentIcon);

                Integer sunriseTime = weather.getDaily().get(0).getSunrise();
                Integer sunsetTime = weather.getDaily().get(0).getSunset();
                adapterHour.setWeatherHourList(weather.getHourly(), sunriseTime , sunsetTime );
                adapterHour.notifyDataSetChanged();

                adapterDay.setWeatherDayList(weather.getDaily());
                adapterDay.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });

        return view;
    }
}