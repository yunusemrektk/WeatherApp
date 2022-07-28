package com.app.weather.domain.repository

import com.app.weather.data.remote.dto.weather_forecast.WeatherForecastDto

interface WeatherRepository {
    
    suspend fun getWeatherForecast(city: String): WeatherForecastDto
}