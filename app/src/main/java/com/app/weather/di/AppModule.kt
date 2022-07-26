package com.app.weather.di

import com.app.weather.common.Constants
import com.app.weather.data.remote.WeatherApi
import com.app.weather.data.repository.WeatherRepositoryImpl
import com.app.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherApiRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

}