package com.app.weather.domain.model.weather_forecast

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelsLike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val temp_c: Double,
    val locName: String,
    val wind_kph: Double,
)
