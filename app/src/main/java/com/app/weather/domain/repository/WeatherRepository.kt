package com.app.weather.domain.repository

import com.app.weather.data.remote.dto.weather.WeatherDto
import com.app.weather.data.remote.dto.weather_forecast.WeatherForecastDto

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherDto

    suspend fun getWeatherForecast(city: String): WeatherForecastDto
}