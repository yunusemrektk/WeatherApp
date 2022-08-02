package com.app.weather.presentation

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.app.weather.presentation.forecast.WeatherForecastViewModel
import com.app.weather.presentation.forecast.WeatherScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherForecastViewModel by viewModels()
    private lateinit var permission: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) {
                viewModel.loadWeatherInfo()
            }

        permission.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION)
        )
        setContent {
            WeatherScreen(state = viewModel.state)
            if(viewModel.state.isLoading) {
                CircularProgressIndicator()
            }
            viewModel.state.error?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}
