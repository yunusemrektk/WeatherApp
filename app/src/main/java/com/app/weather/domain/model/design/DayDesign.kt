package com.app.weather.domain.model.design

import androidx.annotation.DrawableRes
import com.app.weather.R

sealed class DayDesign(
    @DrawableRes val primaryColor: Int,
    @DrawableRes val secondaryColor: Int,
) {
    object Day : DayDesign(
        primaryColor = R.color.primaryBlue,
        secondaryColor = R.color.secondaryBlue
    )

    object Night : DayDesign(
        primaryColor = R.color.darkColorPrimary,
        secondaryColor = R.color.darkColorSecondary
    )

    companion object {
        fun fromDayCode(code: Int): DayDesign {
            return when (code) {
                1 -> Day
                else -> Night
            }
        }
    }
}