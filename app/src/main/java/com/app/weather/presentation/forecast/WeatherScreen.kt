package com.app.weather.presentation.forecast

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Current
import com.app.weather.domain.model.weather_forecast.Day
import com.app.weather.presentation.forecast.components.CurrentItem
import com.app.weather.presentation.forecast.components.WeatherAstro
import com.app.weather.presentation.forecast.components.WeatherDetailItem
import com.app.weather.presentation.forecast.components.WeatherForecastItem
import com.app.weather.R
import com.app.weather.data.remote.dto.weather_forecast.Astro
import com.app.weather.domain.model.weather_forecast.WeatherForecast

@Preview
@Composable
fun composeScreen(){
    val weatherDetailItem = Day(1.0,27.0,
        Condition(1,"test","Sunny"),
        25,0,15,
        0,42.0,25.0)

    val currentItem = Current(1,
        Condition(1,"icon","Sunny"),38.0,15,1,35.0,"Ordu"
    )
    val astro = Astro("0","New Moon","04:20 AM", "09.27 PM", "05:18 AM", "08:55 PM")

    //WeatherScreen(currentItem, weatherDetailItem, astro)

}

@Composable
fun WeatherScreen(forecast: WeatherForecast) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(8.dp),
        backgroundColor = colorResource(id = R.color.secondaryGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(16.dp),
                backgroundColor = colorResource(id = R.color.primaryBlue)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    CurrentItem(current = forecast.current)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeatherDetailItem(forecast.forecast.forecast[0].day, forecast.current.humidity)
                }
            }

            //Forecast days
            Card(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.secondaryBlue)
            ) {
                LazyColumn(modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(6.dp)
                ) {
                    items(forecast.forecast.forecast) {
                            forecastDay ->
                        WeatherForecastItem(forecastDay)
                    }
                }
            }

            //Extra

                Column(modifier = Modifier.fillMaxWidth()) {
                    WeatherAstro(forecast.forecast.forecast[0].astro)
                }

        }


    }

}