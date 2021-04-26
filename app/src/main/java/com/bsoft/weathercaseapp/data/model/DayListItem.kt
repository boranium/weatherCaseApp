package com.bsoft.weathercaseapp.data.model

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DayListItem (
    val id: Double,
    val weather_state_name: String,
    val weather_state_abbr: String,
    val wind_direction_compass: String,
    val created: String,
    val applicable_date: String,
    val min_temp: Double,
    val max_temp: Double,
    val the_temp: Double,
    val wind_speed: Double,
    val wind_direction: Double,
    val humidity: Double,
    val visibility: Double,
    val air_pressure: Double,
    val predictability: Double
){
    fun getDegreesString() : String {
        return (max_temp.toInt()).toString() + "° / " + (min_temp.toInt()).toString() + "°"
    }

    fun getDayName() : String {
        var dateObj = Date()
        val format = SimpleDateFormat("yyyy-MM-dd")
        try {
            dateObj = format.parse(applicable_date)
            println("Date ->$applicable_date")
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return DateFormat.getDateInstance(DateFormat.FULL).format(dateObj.time)
    }
}