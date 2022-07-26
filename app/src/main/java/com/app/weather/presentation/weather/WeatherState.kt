package com.app.weather.presentation.weather

import com.app.weather.domain.model.weather.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String = "")