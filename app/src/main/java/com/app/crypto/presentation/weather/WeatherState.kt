package com.app.crypto.presentation.weather

import com.app.crypto.domain.model.weather.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String = "")