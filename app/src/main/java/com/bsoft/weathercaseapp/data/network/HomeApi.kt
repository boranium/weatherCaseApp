package com.bsoft.weathercaseapp.data.network

import com.bsoft.weathercaseapp.data.model.HomeListItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface HomeApi {
    @GET()
    suspend fun getList(@Url url: String) : Response<List<HomeListItem>>

    companion object {
        operator fun invoke() : HomeApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.metaweather.com/api/location/search/")
                .build()
                .create(HomeApi::class.java)
        }
    }
}