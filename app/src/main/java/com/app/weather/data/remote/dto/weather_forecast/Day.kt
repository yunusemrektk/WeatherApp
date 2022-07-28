package com.app.weather.data.remote.dto.weather_forecast

data class Day(
    val condition: Condition,
    val daily_chance_of_rain: Int,
    val daily_chance_of_snow: Int,
    val daily_will_it_rain: Int,
    val daily_will_it_snow: Int,
    val maxTemp_c: Double,
    val maxWind_kph: Double,
    val minTemp_c: Double,
)