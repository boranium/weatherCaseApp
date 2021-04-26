package com.bsoft.weathercaseapp.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bsoft.weathercaseapp.R
import com.bsoft.weathercaseapp.data.network.HomeApi
import com.bsoft.weathercaseapp.data.repository.HomeRepository
import com.bsoft.weathercaseapp.ui.MainActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(){

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var factory: HomeViewModelFactory
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = HomeApi()
        val repository = HomeRepository(api)
        factory = HomeViewModelFactory(repository)
        viewModel = ViewModelProviders.of(requireActivity(), factory).get(HomeViewModel::class.java)
        (activity as MainActivity).homeViewModel = viewModel
        println(this)

        viewModel.items.observe(viewLifecycleOwner, Observer { items ->
            list_locationList.also {
                it.layoutManager = GridLayoutManager(requireContext(), 2)
                it.setHasFixedSize(false)
                it.adapter = HomeListAdapter(items)
            }
        })

        viewModel.getLocationList(requireActivity() as MainActivity)

        /*if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                111)
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                112)
            return
        }
        else {
            /*
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val latStr = String.format("%.2f", location.latitude)
                    val lonStr = String.format("%.2f", location.longitude)
                    val latlon = "$latStr,$lonStr"
                    println(latlon)


                    viewModel.getList("https://www.metaweather.com/api/location/search/?lattlong=$latlon")
                } else {
                    println("nuuu")
                }
            }
             */

        }*/


    }


}