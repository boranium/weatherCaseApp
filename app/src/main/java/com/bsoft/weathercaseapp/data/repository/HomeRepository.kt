package com.bsoft.weathercaseapp.data.repository

import com.bsoft.weathercaseapp.data.network.HomeApi

class HomeRepository(
    private val homeApi: HomeApi
) : HomeApiRequest() {

    suspend fun getList(url: String) = homeApiRequest {
        homeApi.getList(url)
    }

}