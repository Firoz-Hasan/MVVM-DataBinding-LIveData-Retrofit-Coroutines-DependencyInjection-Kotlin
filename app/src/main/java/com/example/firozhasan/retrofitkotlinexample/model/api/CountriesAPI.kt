package com.example.firozhasan.retrofitkotlinexample.model.api

import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountriesAPI {

    @GET("rest/v2/all")
    fun getAllCountries() : Response<List<Country>>

    companion object {
        operator fun invoke(
               networkConnectionInterceptor: NetworkConnectionInterceptor
        ): CountriesAPI {

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(networkConnectionInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://restcountries.eu/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CountriesAPI::class.java)
        }
    }

}

