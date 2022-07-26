package com.app.weather.domain.model.weather

import com.app.weather.domain.model.common.Location

data class Weather(
    val current: Current,
    val location: Location
)
