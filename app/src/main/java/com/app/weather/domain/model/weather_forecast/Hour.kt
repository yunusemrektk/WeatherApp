package com.app.weather.domain.model.weather_forecast

data class Hour(
    val text: String,
    val time: String,
    val icon: String,
    val temp_c: Double
)