package com.app.crypto.domain.model.weather

import com.app.crypto.domain.model.common.Location

data class Weather(
    val current: Current,
    val location: Location
)
