package com.app.weather.domain.usecases.getweathers

import com.app.weather.common.Resource
import com.app.weather.data.remote.dto.weather_forecast.toWeatherForecast
import com.app.weather.domain.model.weather_forecast.WeatherForecast
import com.app.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(city: String): Flow<Resource<WeatherForecast>> = flow {
        try {
            emit(Resource.Loading<WeatherForecast>())
            val weather = repository.getWeatherForecast(city).toWeatherForecast()
            emit(Resource.Success<WeatherForecast>(weather))

        } catch (e: HttpException) {
            emit(Resource.Error<WeatherForecast>(e.localizedMessage ?: "http exception"))
        } catch (e: IOException) {
            emit(Resource.Error<WeatherForecast>(e.localizedMessage ?: "io exception"))
        }
    }
}