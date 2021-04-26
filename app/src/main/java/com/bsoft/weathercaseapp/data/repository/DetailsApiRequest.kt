package com.bsoft.weathercaseapp.data.repository

import retrofit2.Response
import java.io.IOException

abstract class DetailsApiRequest {

    suspend fun <T: Any> detailsApiRequest(call: suspend() -> Response<T>) : T {
        val response = call.invoke()

        if(response.isSuccessful) {
            return response.body()!!
        }
        else{
            //@todo handle api exception
            println("RESPONSE ERROR ${response.raw()}")
            throw DetailsApiException(
                response.code().toString()
            )
        }
    }

}

class DetailsApiException(message: String): IOException(message)