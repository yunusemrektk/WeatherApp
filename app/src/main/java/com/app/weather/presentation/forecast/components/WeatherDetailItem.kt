package com.app.weather.presentation.forecast.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.R
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Current
import com.app.weather.domain.model.weather_forecast.Day

@Composable
fun WeatherDetailItem (
    day: Day,
    humidity: Int
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(16.dp),
        backgroundColor = colorResource(id = R.color.secondaryBlue)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "${humidity}%",
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Text(
                text = "${day.daily_chance_of_rain}%",
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Text(
                text = "H:${day.maxtemp_c}°",
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Text(
                text = "L:${day.mintemp_c}°",
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )

        }
    }
}