package com.app.weather.presentation.forecast.components
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
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.app.weather.domain.model.weather_forecast.Condition
import com.app.weather.domain.model.weather_forecast.Current

@Composable
fun CurrentItem (
    current: Current
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = current.locName,
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

        Image(painter = rememberAsyncImagePainter(model = "https:${current.condition.icon}"), contentDescription =null, Modifier.size(64.dp) )

        Text(
            text = "${current.temp_c}°",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
    }
}