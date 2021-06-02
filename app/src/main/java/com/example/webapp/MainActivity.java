package com.example.webapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.webapp.Adapter.WeatherAdapter;
import com.example.webapp.Model.Weather;
import com.example.webapp.Network.ApiClient;
import com.example.webapp.Network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvCityName;
    RecyclerView rvHour;
    WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCityName = findViewById(R.id.tvCityName);
        rvHour = findViewById(R.id.rvHour);
        adapter = new WeatherAdapter();
        rvHour.setAdapter(adapter);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Weather> call =  apiService.getWeatherInfo(55.751244, 37.618423,
                "minutely", getString(R.string.apiKey), "metric", "ru");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                tvCityName.setText(weather.getTimezone());
                adapter.setWeatherList(weather.getHourly());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });

    }
}