package com.app.weather.presentation.forecast

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.weather.common.Constants
import com.app.weather.common.Resource
import com.app.weather.domain.usecases.getweathers.GetWeatherForecastUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class WeatherForecastViewModel  @Inject constructor(
    private val getForecastUseCase: GetWeatherForecastUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ForecastState())
    val state: State<ForecastState> = _state

    init {
        savedStateHandle.get<String>(Constants.PRM_CITY)?.let { city ->
            getWeather(city)
        }
    }

    private fun getWeather(city: String) {
        getForecastUseCase(city).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ForecastState(weather = result.data!!)
                }
                is Resource.Error -> {
                    _state.value =
                        ForecastState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = ForecastState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}