package com.example.firozhasan.retrofitkotlinexample.model.api

import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

    }
    private fun isInternetAvailable() : Boolean{

    }
}