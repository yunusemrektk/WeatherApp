package com.app.weather.data.remote

import com.app.weather.data.remote.dto.weather_forecast.WeatherForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String,
        @Query("q") city: String,
        @Query("days") days: String
    ): WeatherForecastDto


}