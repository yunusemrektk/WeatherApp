package com.app.weather.presentation.weather.components

import android.widget.AdapterView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.domain.model.common.Location
import com.app.weather.domain.model.weather.Condition
import com.app.weather.domain.model.weather.Current
import com.app.weather.domain.model.weather.Weather

/*
@Preview
@Composable
fun ComposeWeather(){
    WeatherItem(weather = Weather(
        Current(1,
            Condition(1,"test","Sunny"), 38.0, 15, 3, 39),
            Location("Turkey", 15.0, "15:00", "Ordu", "region")
    ))
}
*/


@Composable
fun WeatherItem (
    weather: Weather
) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)) {
            Card(elevation = 4.dp) {
                Column(modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${weather.location.name}",
                        style = MaterialTheme.typography.h3,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Black
                    )
                    Text(
                        text = "${weather.current.condition.text}",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Black
                    )
                    Text(
                        text = "${weather.current.temp_c}°",
                        style = MaterialTheme.typography.h2,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Black
                    )
                    Text(
                        text = "Feels Like: ${weather.current.feelslike_c}°",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Black
                    )
                }

            }
        }
}


