package com.app.weather.domain.repository

import com.app.weather.domain.model.weather_forecast.WeatherForecast

interface WeatherRepository {

    suspend fun getWeatherForecast(city: String): WeatherForecast
}