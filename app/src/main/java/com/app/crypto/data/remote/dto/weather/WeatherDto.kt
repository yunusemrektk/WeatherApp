package com.app.crypto.data.remote.dto.weather

import com.app.crypto.domain.model.weather.Condition
import com.app.crypto.domain.model.weather.Weather

data class WeatherDto(
    val current: Current,
    val location: Location
)

fun WeatherDto.toWeather(): Weather {
    return Weather(
        current = com.app.crypto.domain.model.weather.Current(
            current.cloud,
            Condition(current.condition.code, current.condition.icon, current.condition.text),
            current.feelslike_c,
            current.humidity,
            current.is_day,
            current.temp_c
        ),
        location = com.app.crypto.domain.model.common.Location(
            location.country,
            location.lat,
            location.localtime,
            location.name,
            location.region
        )
    )
}