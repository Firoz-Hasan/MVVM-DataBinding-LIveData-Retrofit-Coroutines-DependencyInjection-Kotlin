package com.example.firozhasan.retrofitkotlinexample.model.api

import com.example.firozhasan.retrofitkotlinexample.`interface`.Constant
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesAPI {

    @GET(Constant.ALL_COUNTIRES)
    suspend fun getAllCountries() : Response<List<Country>>

    @GET(Constant.CAPITAL)
    suspend fun getCountry(@Path("capital") capitalOfCountry: String): Response<List<Country>>


    companion object {
        operator fun invoke(
               networkConnectionInterceptor: NetworkConnectionInterceptor
        ): CountriesAPI {

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(networkConnectionInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CountriesAPI::class.java)
        }
    }

}

