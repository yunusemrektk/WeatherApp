package com.app.weather.data.remote.dto.weather_forecast

data class Hour(
    val chance_of_rain: Int,
    val chance_of_snow: Int,
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val temp_c: Double,
    var time: String,
    val will_it_rain: Int,
    val will_it_snow: Int,
)