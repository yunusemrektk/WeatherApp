package com.app.weather.domain.usecases.getweather

import com.app.weather.common.Resource
import com.app.weather.data.remote.dto.weather.toWeather
import com.app.weather.domain.model.weather.Weather
import com.app.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(city: String): Flow<Resource<Weather>> = flow {
        try {
            emit(Resource.Loading<Weather>())
            val weather = repository.getWeather(city).toWeather()
            emit(Resource.Success<Weather>(weather))

        } catch (e: HttpException) {
            emit(Resource.Error<Weather>(e.localizedMessage ?: "http exception"))
        } catch (e: IOException) {
            emit(Resource.Error<Weather>(e.localizedMessage ?: "io exception"))
        }
    }
}