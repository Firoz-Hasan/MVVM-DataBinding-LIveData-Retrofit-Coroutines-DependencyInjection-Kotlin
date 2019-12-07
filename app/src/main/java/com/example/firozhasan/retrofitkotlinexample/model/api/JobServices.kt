package com.example.firozhasan.retrofitkotlinexample.model.api

import com.example.firozhasan.retrofitkotlinexample.inter.Constant
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface JobServices {

    @GET(Constant.CAPITAL)
    fun getKountry(@Path("capital") capitalOfCountry: String): Call<List<Country>>

    @GET(Constant.ALL_COUNTIRES)
    fun getAllCountries() : Call<List<Country>>

    @FormUrlEncoded
    @POST(Constant.LOGIN)
    suspend fun userLogin(
            @Field("email") email: String,
            @Field("password") password: String

    ) : Response<User>
}