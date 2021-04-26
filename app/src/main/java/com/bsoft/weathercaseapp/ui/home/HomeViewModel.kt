package com.bsoft.weathercaseapp.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bsoft.weathercaseapp.data.model.HomeListItem
import com.bsoft.weathercaseapp.data.repository.HomeRepository
import com.bsoft.weathercaseapp.other.Coroutine
import com.bsoft.weathercaseapp.ui.MainActivity
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Job

class HomeViewModel( private val repository: HomeRepository) : ViewModel() {

    private lateinit var job: Job

    val items = MutableLiveData<List<HomeListItem>>()

    fun getList(url: String) {
        job = Coroutine.iothenMain(
            { repository.getList(url) },
            { itemList ->
                items.value = itemList
            }
        )
    }

    fun getLocationList(mainActivity: MainActivity) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(mainActivity)
        if (ActivityCompat.checkSelfPermission(
                mainActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                mainActivity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(mainActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                111)
            ActivityCompat.requestPermissions(mainActivity,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                112)
            return
        }
        else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val latStr = String.format("%.2f", location.latitude)
                    val lonStr = String.format("%.2f", location.longitude)
                    val latlon = "$latStr,$lonStr"
                    println(latlon)
                    getList("https://www.metaweather.com/api/location/search/?lattlong=$latlon")
                }
            }
        }
    }
}