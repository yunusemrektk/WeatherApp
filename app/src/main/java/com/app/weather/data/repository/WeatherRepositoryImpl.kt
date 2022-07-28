package com.app.weather.data.repository

import com.app.weather.data.remote.WeatherApi

import com.app.weather.data.remote.dto.weather_forecast.WeatherForecastDto
import com.app.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherForecast(city: String): WeatherForecastDto {
        return api.getWeatherForecast(city)
    }
}