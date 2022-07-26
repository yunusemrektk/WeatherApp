package com.app.weather.data.remote.dto.weather_forecast

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)