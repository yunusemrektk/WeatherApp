package com.app.weather.domain.location

interface LocationTracker {
    suspend fun getCurrentLocation(): String?
}