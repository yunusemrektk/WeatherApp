package com.app.weather.data.remote.dto.weather_forecast

data class Forecastday(
    val astro: Astro,
    var date: String,
    val date_epoch: Int,
    val day: Day,
    var hour: List<Hour>
)