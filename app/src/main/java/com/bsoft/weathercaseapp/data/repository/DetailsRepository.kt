package com.bsoft.weathercaseapp.data.repository

import com.bsoft.weathercaseapp.data.network.DetailsApi

class DetailsRepository(
    private val detailsApi: DetailsApi
) : DetailsApiRequest() {

    suspend fun getList(url: String) = detailsApiRequest { detailsApi.getList(url) }

}