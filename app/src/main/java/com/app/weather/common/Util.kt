package com.app.weather.common

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object Util {
    @SuppressLint("NewApi")
    @JvmStatic
    fun formatHourHHmm(date: String): String {
        val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return LocalDateTime.parse(date, dateFormat).format(timeFormat)
    }

    @JvmStatic
    fun parseHourFromFullString(hour: String): String {
        return hour.substring(11)
    }

    @JvmStatic
    fun convertStringUpperCaseToProperCase(case: String): String {
        return case[0] + case.substring(1).lowercase(Locale.getDefault())
    }
}