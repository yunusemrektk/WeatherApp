package com.app.weather

import com.app.weather.data.remote.dto.weather_forecast.Forecast
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        println("EMRE")
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        dateFormat.parse("2022-07-27")
        val parse = LocalDate.parse("2022-07-27").dayOfWeek.name

        println(parse)

    }
}