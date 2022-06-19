package com.app.crypto.presentation.weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.crypto.common.Constants
import com.app.crypto.common.Resource
import com.app.crypto.domain.usecases.getweather.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init {
        savedStateHandle.get<String>(Constants.PRM_CITY)?.let { city ->
            getWeather(city)
        }
    }

    private fun getWeather(city: String) {
        getWeatherUseCase(city).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = WeatherState( weather = result.data)
                }
                is Resource.Error -> {
                    _state.value = WeatherState( error = result.message?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = WeatherState( isLoading = true)
                }
            } }
        }
    }