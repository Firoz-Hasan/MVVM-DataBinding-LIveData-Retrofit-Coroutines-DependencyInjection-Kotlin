package com.example.firozhasan.retrofitkotlinexample.model.api

import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginAPI {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
            @Field("email") email: String,
            @Field("password") password: String
    ): Response<User>

    companion object {
        operator fun invoke(
               networkConnectionInterceptor: NetworkConnectionInterceptor
        ): LoginAPI {

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(networkConnectionInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(LoginAPI::class.java)
        }
    }

}

