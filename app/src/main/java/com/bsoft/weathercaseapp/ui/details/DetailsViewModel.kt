package com.bsoft.weathercaseapp.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bsoft.weathercaseapp.data.model.DayListItem
import com.bsoft.weathercaseapp.data.repository.DetailsRepository
import com.bsoft.weathercaseapp.other.Coroutine
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Job


class DetailsViewModel( private val repository: DetailsRepository) : ViewModel() {
    private lateinit var job: Job

    val items = MutableLiveData<List<DayListItem>>()
    var dayDegree = ""
    var nightDegree = ""
    var state = ""
    var showLoadingAnim = MutableLiveData<Boolean>()

    fun getList(url: String) {
        showLoadingAnim.value = true
        job = Coroutine.iothenMain(
            { repository.getList(url) },
            { map ->
                val daysList = mutableListOf<DayListItem>()
                val daysRaw = map!!["consolidated_weather"] as List<Map<String, Any>>
                daysRaw.forEach {
                    daysList.add(DayListItem(   it["id"] as Double,
                                                it["weather_state_name"] as String,
                                                it["weather_state_abbr"] as String,
                                                it["wind_direction_compass"] as String,
                                                it["created"] as String,
                                                it["applicable_date"] as String,
                                                it["min_temp"] as Double,
                                                it["max_temp"] as Double,
                                                it["the_temp"] as Double,
                                                it["wind_speed"] as Double,
                                                it["wind_direction"] as Double,
                                                it["air_pressure"] as Double,
                                                it["humidity"] as Double,
                                                it["visibility"] as Double,
                                                it["predictability"] as Double
                                            ))
                }

                dayDegree = daysList[0].max_temp.toInt().toString()
                nightDegree = daysList[0].min_temp.toInt().toString()
                state = daysList[0].weather_state_name
                showLoadingAnim.value = false
                items.value = daysList
            }
        )
    }

    fun resetList() {
        dayDegree = ""
        nightDegree = ""
        state = ""
        items.value = listOf()

    }
}