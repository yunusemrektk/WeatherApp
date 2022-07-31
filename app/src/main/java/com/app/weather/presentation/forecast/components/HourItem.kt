package com.app.weather.presentation.forecast.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.domain.model.weather_forecast.Current
import com.app.weather.domain.model.weather_forecast.Hour

@Preview
@Composable
fun composeItem() {
    HourItem()
}

@Composable
fun HourItem (
    //hour: Hour
) {

    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            //  text = "${hour.time}",
            text = "01:00",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )

        /*            Image(
                painter = rememberAsyncImagePainter("https:$weather.current.condition.icon"),
                contentDescription = "condition icon"
            )*/
        Text(
            // text = "${hour.condition.icon}",
            text = "icon",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Text(
            // text = "${hour.temp_c}°",
            text = "26°",
            style = MaterialTheme.typography.h4,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
    }

}