package com.app.crypto.domain.usecases.getweather

import com.app.crypto.common.Resource
import com.app.crypto.data.remote.dto.weather.toWeather
import com.app.crypto.domain.model.weather.Weather
import com.app.crypto.domain.repository.WeatherRepository
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
            emit(Resource.Loading())
            val weather = repository.getWeather(city).toWeather()
            emit(Resource.Success(weather))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "http exception"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "io exception"))
        }
    }
}