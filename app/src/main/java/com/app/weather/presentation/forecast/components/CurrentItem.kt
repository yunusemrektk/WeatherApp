package com.app.weather.presentation.forecast.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.weather.domain.model.weather_forecast.Current
import com.app.weather.domain.model.weather_forecast.Location

@Composable
fun CurrentItem(
    current: Current,
    location: Location
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = location.name,
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Text(
            text = current.condition.text,
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )

        Image(
            painter = rememberAsyncImagePainter(model = "https:${current.condition.icon}"),
            contentDescription = null,
            Modifier.size(64.dp)
        )

        Text(
            text = "${current.temp_c}°",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )

        Text(
            text = location.time,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
    }
}