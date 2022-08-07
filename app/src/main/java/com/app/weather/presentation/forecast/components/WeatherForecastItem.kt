package com.app.weather.presentation.forecast.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.weather.data.remote.dto.weather_forecast.Astro
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Day
import com.app.weather.domain.model.weather_forecast.ForecastDay
import com.app.weather.domain.model.weather_forecast.Hour

@Preview
@Composable
fun composeForecastItem() {
    val hour = ArrayList<Hour>(5)
    val hourItem = Hour("Rainy", "10:00", "//cdn.weatherapi.com/weather/64x64/day/116.png", 39.0)
    hour.add(hourItem)
    val dayItem2 = ForecastDay(
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
        ), hour = hour
    )

    WeatherForecastItem(forecastDay = dayItem2)
}

@Composable
fun WeatherForecastItem(
    forecastDay: ForecastDay
) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = forecastDay.date,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            modifier = Modifier.widthIn(100.dp)
        )

        Image(
            painter = rememberAsyncImagePainter(model = "https:${forecastDay.day.condition.icon}"),
            contentDescription = null,
            Modifier.size(48.dp)
        )
        Text(
            text = "${forecastDay.day.maxtemp_c}°",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            modifier = Modifier.widthIn(64.dp)
        )

        Text(
            text = "${forecastDay.day.mintemp_c}°",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            modifier = Modifier.widthIn(64.dp)
        )

    }

}


