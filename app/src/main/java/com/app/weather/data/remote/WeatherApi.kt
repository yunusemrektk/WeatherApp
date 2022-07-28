package com.app.weather.data.remote

import com.app.weather.data.remote.dto.weather_forecast.WeatherForecastDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {

    @GET("v1/forecast.json?key=a687aaf455f64071a0a95437221806&q={city}&days=7")
    suspend fun getWeatherForecast(@Path("city") city: String): WeatherForecastDto


}