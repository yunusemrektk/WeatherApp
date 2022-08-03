package com.app.weather.presentation.forecast

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.app.weather.presentation.forecast.components.CurrentItem
import com.app.weather.presentation.forecast.components.WeatherDetailItem
import com.app.weather.presentation.forecast.components.WeatherForecastItem
import com.app.weather.R
import com.app.weather.data.remote.dto.weather_forecast.Astro
import com.app.weather.domain.model.weather_forecast.*
import com.app.weather.presentation.forecast.components.HourItem
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import kotlin.math.absoluteValue

@Preview
@Composable
fun composeScreen() {
    val day = ArrayList<ForecastDay>(3)

    val hour = ArrayList<Hour>(5)
    val hourItem = Hour("Rainy", "10:00","//cdn.weatherapi.com/weather/64x64/day/116.png",39.0)

    val dayItem =  ForecastDay(
        astro = Astro(
            moon_illumination = "51",
            moon_phase = "First Quarter",
            moonrise = "02:13 PM",
            moonset = "12:02 AM",
            sunrise = "06:17 AM",
            sunset = "08:12 PM"
        ),
        date = "Frid",
        date_epoch = 1659657600,
        day = Day(
            avghumidity = 65.0,
            avgtemp_c = 19.8,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                text = "Sunny"
            ),
            daily_chance_of_rain = 0,
            daily_chance_of_snow = 0,
            daily_will_it_rain = 0,
            daily_will_it_snow = 0,
            maxtemp_c = 29.5,
            mintemp_c = 13.6
        )
    , hour = hour)
    val dayItem2 =  ForecastDay(
        astro = Astro(
            moon_illumination = "51",
            moon_phase = "First Quarter",
            moonrise = "02:13 PM",
            moonset = "12:02 AM",
            sunrise = "06:17 AM",
            sunset = "08:12 PM"
        ),
        date = "Wednesday",
        date_epoch = 1659657600,
        day = Day(
            avghumidity = 65.0,
            avgtemp_c = 19.8,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                text = "Sunny"
            ),
            daily_chance_of_rain = 0,
            daily_chance_of_snow = 0,
            daily_will_it_rain = 0,
            daily_will_it_snow = 0,
            maxtemp_c = 29.5,
            mintemp_c = 13.6
        )
        , hour = hour)
    hour.add(hourItem)
    hour.add(hourItem)
    hour.add(hourItem)
    hour.add(hourItem)
    hour.add(hourItem)
    day.add(dayItem)
    day.add(dayItem)
    day.add(dayItem2)
    day.add(dayItem)
    day.add(dayItem)
    day.add(dayItem2)


    val item = WeatherForecast(
        current = Current(
            cloud = 25,
            condition = Condition(
                code = 1003,
                icon = "//cdn.weatherapi.com/weather/64x64/day/116.png",
                text = "Partly cloudy"
            ),
            feelsLike_c = 20.6,
            humidity = 65,
            is_day = 1,
            temp_c = 20.6,
            locName = "Mountain View",
            25.0
        ),
        forecast = Forecast(forecast = day)
    )

    WeatherScreen(state = WeatherState(isLoading = false, item, null))
}

@SuppressLint("ResourceType")
@Composable
fun WeatherScreen(
    state: WeatherState
) {
    state.weather?.let { data ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.primaryBlue),
                            colorResource(id = R.color.secondaryBlue),
                        )
                    )
                )
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    CurrentItem(current = data.current)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherDetailItem(data.forecast.forecast[0].day, data.current.humidity, data.current.wind_kph)
                }
                //Hour
                Card(
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = colorResource(id = R.color.secondaryBlue)
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(6.dp)
                    ) {
                        items(data.forecast.forecast[0].hour) { hour ->
                            HourItem(hour = hour)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                //Forecast days
                Card(
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = colorResource(id = R.color.secondaryBlue)
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxHeight(),
                        contentPadding = PaddingValues(6.dp)
                    ) {
                        items(data.forecast.forecast) { forecastDay ->
                            WeatherForecastItem(forecastDay)
                        }
                    }
                }

            }


        }
    }


}