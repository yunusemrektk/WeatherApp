package com.app.weather.data.remote.dto.weather_forecast

import android.annotation.SuppressLint
import com.app.weather.common.Util
import com.app.weather.domain.model.design.CurrentDesign
import com.app.weather.domain.model.design.DayDesign
import com.app.weather.domain.model.weather_forecast.*
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Day
import com.app.weather.domain.model.weather_forecast.Hour
import java.time.LocalDate

data class WeatherForecastDto(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

fun WeatherForecastDto.toWeatherForecast(): WeatherForecast {
    return WeatherForecast(
        current = Current(
            current.cloud,
            Condition(
                current.condition.code,
                current.condition.icon,
                current.condition.text
            ),
            current.feelslike_c,
            current.humidity,
            current.is_day,
            current.temp_c,
            current.wind_kph,
            CurrentDesign(
                DayDesign.fromDayCode(current.is_day)
            )
        ),
        forecast = prepareForecastDayData(forecast, location),
        location = Location(
            location.name,
            location.localtime_epoch,
            Util.parseHourFromFullString(location.localtime)
        )
    )
}

private fun prepareForecastDayData(
    forecast: Forecast,
    location: Location
): com.app.weather.domain.model.weather_forecast.Forecast {
    convertDatePatterns(forecast.forecastday)
    return Forecast(
        convertDataToDomain(
            forecast.forecastday,
            location
        )
    )
}

@SuppressLint("NewApi")
private fun convertDatePatterns(listForecastDay: List<Forecastday>) {
    for (index in listForecastDay.indices) {
        val day = listForecastDay[index].date
        val upperCaseDay = LocalDate.parse(day).dayOfWeek.name
        listForecastDay[index].date = Util.convertStringUpperCaseToProperCase(upperCaseDay)
        for (hours in listForecastDay[index].hour) {
            hours.time = Util.formatHourHHmm(hours.time)
        }
    }
}

private fun convertDataToDomain(
    listForecastDay: List<Forecastday>,
    location: Location
): ArrayList<ForecastDay> {
    val listRetVal = ArrayList<ForecastDay>()

    listForecastDay.let { it ->
        it.forEach { it ->
            val listHourRetVal = ArrayList<Hour>()

            it.hour = iterateHoursFromNow(it.hour.toMutableList(), location).toList()

            it.hour.forEach {
                listHourRetVal.add(Hour(it.condition.text, it.time, it.condition.icon, it.temp_c))
            }

            listRetVal.add(
                ForecastDay(
                    it.astro, it.date, it.date_epoch,
                    Day(
                        it.day.avghumidity,
                        it.day.avgtemp_c,
                        Condition(
                            it.day.condition.code,
                            it.day.condition.icon,
                            it.day.condition.text
                        ),
                        it.day.daily_chance_of_rain,
                        it.day.daily_chance_of_snow,
                        it.day.daily_will_it_rain,
                        it.day.daily_will_it_snow,
                        it.day.maxtemp_c,
                        it.day.mintemp_c
                    ), listHourRetVal
                )
            )
        }

    }

    return listRetVal
}

private fun iterateHoursFromNow(
    hour: MutableList<com.app.weather.data.remote.dto.weather_forecast.Hour>,
    location: Location
)
        : MutableList<com.app.weather.data.remote.dto.weather_forecast.Hour> {

    with(hour.listIterator()) {
        forEach {
            if (it.time_epoch < location.localtime_epoch)
                remove()
            else
                return@with
        }
    }

    return hour
}



