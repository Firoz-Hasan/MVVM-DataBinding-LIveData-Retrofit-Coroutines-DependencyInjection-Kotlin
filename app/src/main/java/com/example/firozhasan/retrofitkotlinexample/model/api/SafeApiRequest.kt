package com.example.firozhasan.retrofitkotlinexample.model.api

import android.util.Log
import com.example.firozhasan.retrofitkotlinexample.util.ApiException
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {

        val response = call.invoke()
        val message = StringBuilder()

        if (response?.isSuccessful) {
            Log.d("hellohello","safeapireqsucc+${response.body()} ")

            return response?.body()!!

        }
        else {
            val error = response?.errorBody()?.string()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                //    Log.d("hellohello","safeapireqfail 00000+${response.code()} ")

                } catch (e: JSONException) {
                    message.append("\n")
                }

            }
            message.append("\nError code ${response.code()}")
            Log.d("hellohello","safeapireqfail 00000+${response.code()} ")
            throw ApiException(message.toString())
        }
    }
}