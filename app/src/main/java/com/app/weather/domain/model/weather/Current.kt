package com.app.weather.domain.model.weather

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val temp_c: Int,
)
