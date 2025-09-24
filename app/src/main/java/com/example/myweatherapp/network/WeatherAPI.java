package com.example.myweatherapp.network;

import com.example.myweatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather")
    Call<WeatherResponse> weatherResponse(
            @Query("q") String cityName,
            @Query("appid") String apikey
    );

}
