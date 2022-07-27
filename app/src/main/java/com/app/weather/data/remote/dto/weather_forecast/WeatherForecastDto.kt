package com.app.weather.data.remote.dto.weather_forecast

import android.annotation.SuppressLint
import com.app.weather.domain.model.weather_forecast.WeatherForecast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

data class WeatherForecastDto(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

fun WeatherForecastDto.toWeatherForecast(): WeatherForecast {
    return WeatherForecast(
        current = com.app.weather.domain.model.weather_forecast.Current(
            current.cloud,
            com.app.weather.domain.model.weather_forecast.Condition(
                current.condition.code,
                current.condition.icon,
                current.condition.text
            ),
            current.feelslike_c,
            current.humidity,
            current.is_day,
            current.temp_c
        ),
        forecast = convertDateToDay(forecast)
        ,
        location = com.app.weather.domain.model.common.Location(
            location.country,
            location.lat,
            location.localtime,
            location.name,
            location.region
        )
    )
}

@SuppressLint("NewApi")
private fun convertDateToDay(forecast: Forecast): Forecast{
    val listForecastDay = forecast.forecastday
    for (index in 0..listForecastDay.size) {
        listForecastDay.get(index).date = LocalDate.parse(listForecastDay[index].toString()).dayOfWeek.name
    }

    return Forecast(listForecastDay)
}