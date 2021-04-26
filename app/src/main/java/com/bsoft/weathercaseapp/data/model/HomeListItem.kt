package com.bsoft.weathercaseapp.data.model

class HomeListItem (
    val distance: Int,
    val title: String,
    val location_type: String,
    val woeid: Int,
    val latt_long: String
){
    fun getDistanceString() : String {
        return (distance/1000).toString() + " km"
    }
}