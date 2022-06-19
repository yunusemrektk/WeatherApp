package com.app.crypto.data.remote.dto.weather_forecast

import com.app.crypto.domain.model.weather_forecast.WeatherForecast

data class WeatherForecastDto(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

fun WeatherForecastDto.toWeatherForecast(): WeatherForecast {
    return WeatherForecast(
        current = com.app.crypto.domain.model.weather_forecast.Current(
            current.cloud,
            com.app.crypto.domain.model.weather_forecast.Condition(
                current.condition.code,
                current.condition.icon,
                current.condition.text
            ),
            current.feelslike_c,
            current.humidity,
            current.is_day,
            current.temp_c
        ),
        forecast = forecast
        ,
        location = com.app.crypto.domain.model.common.Location(
            location.country,
            location.lat,
            location.localtime,
            location.name,
            location.region
        )
    )
}