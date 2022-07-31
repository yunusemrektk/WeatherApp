package com.app.weather.presentation

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import com.app.weather.presentation.forecast.ForecastScreen
import com.app.weather.presentation.forecast.WeatherForecastViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherForecastViewModel by viewModels()
    private lateinit var permission: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) {
                viewModel.state.value
            }
        permission.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION)
        )
        setContent {
            ForecastScreen()
        }

    }

}
