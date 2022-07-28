package com.app.weather.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.app.weather.R
import com.app.weather.domain.model.weather_forecast.ForecastDay

@Preview
@Composable
fun ComposeWeather(){
    WeatherForecastItem()
}

@Composable
fun WeatherForecastItem (

) {
    Card(elevation = 4.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Monday",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
            )

            Image(
                painter = painterResource(id = R.drawable.lightning),
                contentDescription = "rainy"
            )

            Text(
                text = "36°",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
            )

            Text(
                text = "28°",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
            )

        }

    }
}


