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

@Composable
fun WeatherScreen(
    state: WeatherState
) {
    state.weather?.let { data ->
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
                        CurrentItem(current = data.current)
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherDetailItem(data.forecast.forecast[0].day, data.current.humidity)
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
                        items(data.forecast.forecast) {
                                forecastDay ->
                            WeatherForecastItem(forecastDay)
                        }
                    }
                }

                //Extra

                Column(modifier = Modifier.fillMaxWidth()) {
                    WeatherAstro(state.weather!!.forecast.forecast[0].astro)
                }

            }


        }
    }


}