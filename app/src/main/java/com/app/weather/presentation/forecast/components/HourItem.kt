package com.app.weather.presentation.forecast.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.weather.domain.model.weather_forecast.Hour


@Composable
fun HourItem (
    hour: Hour
) {

    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = hour.time,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )

        Image(painter = rememberAsyncImagePainter(model = "https:${hour.icon}"), contentDescription =null, Modifier.size(48.dp))

        Text(
            text = hour.text,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Text(
            text = "${hour.temp_c}°",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
    }

}