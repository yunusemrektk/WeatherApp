package com.app.weather.presentation.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.R
import org.intellij.lang.annotations.JdkConstants

@Preview
@Composable
fun composeError() {
    val error = "Uups!! server is not available"
    ErrorScreen(message = error)
}

@Composable
fun ErrorScreen(
    message: String
)  {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.error),
                null
            )

            Spacer(modifier = Modifier.height(64.dp))

            Text(
                text = message,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.subtitle1,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(id = R.color.darkColorPrimary)
            )
        }
    }



}