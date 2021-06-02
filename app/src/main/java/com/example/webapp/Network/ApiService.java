package com.example.webapp.Network;

import com.example.webapp.Model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("onecall")
    Call<Weather> getWeatherInfo(
        @Query("lat") Double lat,
        @Query("lon") Double lon,
        @Query("exclude") String exclude,
        @Query("appid") String appid,
        @Query("units") String units,
        @Query("lang") String lang
    );

}
