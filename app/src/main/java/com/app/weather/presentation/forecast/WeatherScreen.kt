package com.app.weather.presentation.forecast

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.data.remote.dto.weather_forecast.Astro
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Current
import com.app.weather.domain.model.weather_forecast.Day
import com.app.weather.presentation.forecast.components.CurrentItem
import com.app.weather.presentation.forecast.components.HourItem
import com.app.weather.presentation.forecast.components.WeatherAstro
import com.app.weather.presentation.forecast.components.WeatherDetailItem
import com.app.weather.presentation.weather.components.WeatherForecastItem

@Preview
@Composable
fun composeScreen(){
    val weatherDetailItem = Day(1,27.0,
        Condition(1,"test","Sunny"),
        25,0,15,
        0,42.0,25.0)

    val currentItem = Current(1,
        Condition(1,"icon","Sunny"),38.0,15,1,35.0,"Ordu"
    )
    val astro = Astro("0","New Moon","04:20 AM", "09.27 PM", "05:18 AM", "08:55 PM")

    WeatherScreen(currentItem, weatherDetailItem, astro)

}

@Composable
fun WeatherScreen(current: Current, day: Day, astro: Astro) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(8.dp),
        backgroundColor = Color.LightGray
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(16.dp),
                backgroundColor = Color.Gray
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    CurrentItem(current = current)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherDetailItem(day, current.humidity)
                }
            }

            //Forecast days
            Card(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color.Yellow
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    WeatherForecastItem()
                }
            }

            //Extra
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(4.dp),
                backgroundColor = Color.LightGray
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    WeatherAstro(astro)
                }
            }
        }


    }

}