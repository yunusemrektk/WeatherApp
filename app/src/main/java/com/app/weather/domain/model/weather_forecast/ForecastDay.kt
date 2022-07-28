package com.app.weather.domain.model.weather_forecast

import com.app.weather.data.remote.dto.weather_forecast.Astro
import com.app.weather.data.remote.dto.weather_forecast.Day

data class ForecastDay (
    val astro: Astro,
    var date: String,
    val date_epoch: Int,
    val day: Day,
)
