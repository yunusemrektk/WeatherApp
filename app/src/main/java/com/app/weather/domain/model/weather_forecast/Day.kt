package com.app.weather.domain.model.weather_forecast

data class Day(
    val avghumidity: Int,
    val avgtemp_c: Double,
    val avgvis_km: Int,
    val condition: Condition,
    val daily_chance_of_rain: Int,
    val daily_chance_of_snow: Int,
    val daily_will_it_rain: Int,
    val daily_will_it_snow: Int,
    val maxtemp_c: Double,
    val maxwind_kph: Double,
    val mintemp_c: Double
)