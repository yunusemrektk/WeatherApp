package com.app.weather.data.remote.dto.weather_forecast

import android.annotation.SuppressLint
import androidx.compose.animation.expandHorizontally
import com.app.weather.domain.model.weather_forecast.ForecastDay
import com.app.weather.domain.model.weather_forecast.Hour
import com.app.weather.domain.model.weather_forecast.WeatherForecast
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
            current.temp_c,
            location.name
        ),
        forecast = convertDateToDay(forecast)
    )
}

@SuppressLint("NewApi")
private fun convertDateToDay(forecast: Forecast): com.app.weather.domain.model.weather_forecast.Forecast{
    val listForecastDay = forecast.forecastday
    val listRetVal  = ArrayList<ForecastDay>(7)

    for (index in 0..listForecastDay.size) {
        listForecastDay[index].date = LocalDate.parse(listForecastDay[index].toString()).dayOfWeek.name
        for(hours in listForecastDay[index].hour) {
            hours.time = formatHour(hours.time)
        }

    }

    listForecastDay.let { it ->
        it.forEach { it ->
            listRetVal.add(ForecastDay(it.astro, it.date, it.date_epoch, it.day))
        }
    }

    return com.app.weather.domain.model.weather_forecast.Forecast(listRetVal)
}

@SuppressLint("NewApi")
private fun formatHour(date: String): String {
    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    return LocalDateTime.parse(date , dateFormat).format(timeFormat)
}