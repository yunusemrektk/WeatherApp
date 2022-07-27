package com.app.weather.presentation.weather.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import com.app.weather.data.remote.dto.weather_forecast.Forecastday

@Composable
fun WeatherForecastItem (
    forecast: Forecastday
) {
    Card(elevation = 4.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "${forecast.day}",
                style = MaterialTheme.typography.h4,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
                    .wrapContentWidth(Alignment.Start)
            )

/*            Image(
                painter = rememberAsyncImagePainter("https:$weather.current.condition.icon"),
                contentDescription = "condition icon"
            )*/
            Text(
                text = "https:${forecast.day.condition.icon}",
                style = MaterialTheme.typography.h4,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )
            Text(
                text = "https:${forecast.day.mintemp_c}",
                style = MaterialTheme.typography.h4,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )

            Text(
                text = "${forecast.day.maxtemp_c}°",
                style = MaterialTheme.typography.h4,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
                    .wrapContentWidth(Alignment.End)
            )

        }

    }
}


