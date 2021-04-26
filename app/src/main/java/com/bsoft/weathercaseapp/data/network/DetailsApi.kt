package com.bsoft.weathercaseapp.data.network

import com.bsoft.weathercaseapp.data.model.DayListItem
import com.bsoft.weathercaseapp.data.model.HomeListItem
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface DetailsApi {

    @GET()
    suspend fun getList(@Url url: String) : Response<Map<String, Any>>

    companion object {
        operator fun invoke() : DetailsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.metaweather.com/api/location/")
                .build()
                .create(DetailsApi::class.java)
        }
    }
}