package com.app.weather.data.remote.dto.weather_forecast

import android.annotation.SuppressLint
import androidx.compose.ui.text.toLowerCase
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Day
import com.app.weather.domain.model.weather_forecast.ForecastDay
import com.app.weather.domain.model.weather_forecast.Hour
import com.app.weather.domain.model.weather_forecast.WeatherForecast
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

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
            location.name,
            current.wind_kph
        ),
        forecast = convertDateToDay(forecast)
    )
}

@SuppressLint("NewApi")
private fun convertDateToDay(forecast: Forecast): com.app.weather.domain.model.weather_forecast.Forecast{
    val listForecastDay = forecast.forecastday
    val listRetVal  = ArrayList<ForecastDay>(7)
    val listHourRetVal = ArrayList<Hour>()

    for (index in listForecastDay.indices) {
        //TODO fix this index problem
        val day = listForecastDay[index].date
        val upperCaseDay = LocalDate.parse(day).dayOfWeek.name
        listForecastDay[index].date = upperCaseDay[0] + upperCaseDay.substring(1)
            .lowercase(Locale.getDefault())
        for(hours in listForecastDay[index].hour) {
            hours.time = formatHour(hours.time)
        }

    }
    //Hour(it.condition.text, it.time, it.condition.icon, it.temp_c)

    listForecastDay.let { it ->
        it.forEach {it ->
            it.hour.forEach {
                listHourRetVal.add(Hour(it.condition.text, it.time, it.condition.icon, it.temp_c))
            }
        }
        it.forEach {
            listRetVal.add(ForecastDay(it.astro, it.date, it.date_epoch,
                Day(it.day.avghumidity,it.day.avgtemp_c, Condition(it.day.condition.code, it.day.condition.icon, it.day.condition.text), it.day.daily_chance_of_rain, it.day.daily_chance_of_snow,it.day.daily_will_it_rain, it.day.daily_will_it_snow, it.day.maxtemp_c, it.day.mintemp_c)
            , listHourRetVal))
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