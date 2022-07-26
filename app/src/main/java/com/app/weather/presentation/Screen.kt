package com.app.weather.presentation

sealed class Screen(val route:String) {
    object WeatherScreen: Screen("weather")
    object WeatherForecastScreen: Screen("weather_forecast")
}