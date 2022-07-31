package com.app.weather

import org.junit.Test

import java.time.LocalDateTime
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
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val parse = formatter.parse("2022-07-28 00:00")

        val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
        val time = LocalDateTime.parse("2022-07-28 00:00" , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).format(timeFormat)

        println(parse)

    }
}