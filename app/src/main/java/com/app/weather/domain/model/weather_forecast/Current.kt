package com.app.weather.domain.model.weather_forecast

import com.app.weather.domain.model.design.CurrentDesign

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelsLike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val temp_c: Double,
    val wind_kph: Double,
    val currentDesign: CurrentDesign
)
