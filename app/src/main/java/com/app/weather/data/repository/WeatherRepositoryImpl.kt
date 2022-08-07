package com.app.weather.data.repository

import com.app.weather.data.remote.WeatherApi
import com.app.weather.data.remote.dto.weather_forecast.toWeatherForecast
import com.app.weather.domain.model.weather_forecast.WeatherForecast
import com.app.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherForecast(city: String): WeatherForecast {
        return api.getWeatherForecast("a687aaf455f64071a0a95437221806", city, "7")
            .toWeatherForecast()
    }
}