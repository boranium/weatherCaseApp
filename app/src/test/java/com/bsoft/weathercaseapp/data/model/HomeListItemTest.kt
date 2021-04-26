package com.bsoft.weathercaseapp.data.model

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class HomeListItemTest {

    var homeListItem = HomeListItem(25507, "CityName", "city", 14410, "-34.05,12.00")

    @Test
    fun getDistanceString() {
        assertEquals(homeListItem.getDistanceString(), "25 km")
    }

    @Test
    fun getDistance() {
        assertEquals(homeListItem.distance, 25507)
    }

    @Test
    fun getTitle() {
        assertEquals(homeListItem.title, "CityName")
    }

    @Test
    fun getLocation_type() {
        assertEquals(homeListItem.location_type, "city")
    }

    @Test
    fun getWoeid() {
        assertEquals(homeListItem.woeid, 14410)
    }

    @Test
    fun getLatt_long() {
        assertEquals(homeListItem.latt_long, "-34.05,12.00")
    }
}