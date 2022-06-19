package com.app.crypto.domain.repository

import com.app.crypto.data.remote.dto.weather.WeatherDto
import com.app.crypto.data.remote.dto.weather_forecast.WeatherForecastDto

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherDto

    suspend fun getWeatherForecast(city: String): WeatherForecastDto
}