package com.bsoft.weathercaseapp.data.model

import org.junit.Test

import org.junit.Assert.*

class DayListItemTest {

    var dayListItem = DayListItem(
        4718561718173696.0,
        "Heavy Cloud",
        "hc",
        "WNW",
        "2021-04-26T10:57:41.255583Z",
        "2021-04-26",
        6.99,
        16.705,
        16.3,
        5.043869601527081,
        288.0,
        1012.0,
        58.0,
        9.999726596675416,
        71.0)
    @Test
    fun getDegreesString() {
        assertEquals(dayListItem.getDegreesString(), "16° / 6°")
    }

    @Test
    fun getDayName() {
        assertEquals(dayListItem.getDayName(), "Monday, April 26, 2021")
    }

    @Test
    fun getId() {
        assert(dayListItem.id == 4718561718173696.0)
    }

    @Test
    fun getWeather_state_name() {
        assertEquals(dayListItem.weather_state_name, "Heavy Cloud")
    }

    @Test
    fun getWeather_state_abbr() {
        assertEquals(dayListItem.weather_state_abbr, "hc")
    }

    @Test
    fun getWind_direction_compass() {
        assertEquals(dayListItem.wind_direction_compass, "WNW")
    }

    @Test
    fun getCreated() {
        assertEquals(dayListItem.created, "2021-04-26T10:57:41.255583Z")
    }

    @Test
    fun getApplicable_date() {
        assertEquals(dayListItem.applicable_date, "2021-04-26")
    }


    @Test
    fun getMin_temp() {
        assert(dayListItem.min_temp == 6.99)
    }

    @Test
    fun getMax_temp() {
        assert(dayListItem.max_temp == 16.705)
    }

    @Test
    fun getThe_temp() {
        assert(dayListItem.the_temp == 16.3)
    }

    @Test
    fun getWind_speed() {
        assert(dayListItem.wind_speed == 5.043869601527081)
    }

    @Test
    fun getWind_direction() {
        assert(dayListItem.wind_direction == 288.0)
    }

    @Test
    fun getHumidity() {
        assert(dayListItem.humidity == 1012.0)
    }

    @Test
    fun getVisibility() {
        assert(dayListItem.visibility == 58.0)
    }

    @Test
    fun getAir_pressure() {
        assert(dayListItem.air_pressure == 9.999726596675416)
    }

    @Test
    fun getPredictability() {
        assert(dayListItem.predictability == 71.0)
    }
}