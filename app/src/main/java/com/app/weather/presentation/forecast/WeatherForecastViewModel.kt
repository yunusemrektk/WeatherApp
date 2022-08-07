package com.app.weather.presentation.forecast

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.weather.domain.location.LocationTracker
import com.app.weather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherForecastViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set


    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            locationTracker.getCurrentLocation()?.let { getWeather(it) }
                ?: kotlin.run {
                    state = state.copy(
                        isLoading = false,
                        error = "Couldn't retrieve location"
                    )
                }
        }
    }

    private suspend fun getWeather(city: String) {
        state = try {
            state.copy(isLoading = false, weather = repository.getWeatherForecast(city), error = null)
        }catch (e: Exception) {
            e.printStackTrace()
            state.copy(
                isLoading = false,
                weather = null,
                error = "Uups!! Server is not available"
            )
        }

    }
}