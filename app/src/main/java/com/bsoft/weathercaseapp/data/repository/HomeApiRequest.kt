package com.bsoft.weathercaseapp.data.repository

import retrofit2.Response
import java.io.IOException

abstract class HomeApiRequest {

    suspend fun <T: Any> homeApiRequest(call: suspend() -> Response<T>) : T {
        val response = call.invoke()

        if(response.isSuccessful) {
            return response.body()!!
        }
        else{
            //@todo handle api exception
            println("RESPONSE ERROR ${response.raw()}")
            throw ApiException(
                response.code().toString()
            )
        }
    }

}

class ApiException(message: String): IOException(message)