package com.app.crypto.domain.model.weather_forecast

import com.app.crypto.data.remote.dto.weather_forecast.Forecast
import com.app.crypto.domain.model.common.Location

data class WeatherForecast(
    val current: Current,
    val forecast: Forecast, // TODO learn how to serialize dto forecast to model forecast (list)
    val location: Location
)
