package com.example.firozhasan.retrofitkotlinexample.model.api

import com.example.firozhasan.retrofitkotlinexample.`interface`.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JobAPI {

    companion object {

        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(Constant.BASE_URL)
                            .build()
                }
                return retrofit!!
            }
    }
}