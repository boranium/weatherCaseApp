package com.bsoft.weathercaseapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.bsoft.weathercaseapp.R
import com.bsoft.weathercaseapp.ui.home.HomeFragment
import com.bsoft.weathercaseapp.ui.home.HomeViewModel
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        println("RESULT RESULT")
        when (requestCode) {
            111 -> {
                homeViewModel.getLocationList(this)
            }
        }
    }
}