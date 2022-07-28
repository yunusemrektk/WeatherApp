package com.app.weather.presentation.forecast

import com.app.weather.domain.model.weather_forecast.WeatherForecast

data class ForecastState(
    val isLoading: Boolean = false,
    val weather: WeatherForecast? = null,
    val error: String = "")