package com.app.crypto.data.repository

import com.app.crypto.data.remote.WeatherApi
import com.app.crypto.data.remote.dto.weather.WeatherDto
import com.app.crypto.data.remote.dto.weather_forecast.WeatherForecastDto
import com.app.crypto.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherDto {
        return api.getWeather(city)
    }

    override suspend fun getWeatherForecast(city: String): WeatherForecastDto {
        return api.getWeatherForecast(city)
    }
}