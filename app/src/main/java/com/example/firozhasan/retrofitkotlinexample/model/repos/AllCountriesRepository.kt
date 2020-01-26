package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firozhasan.retrofitkotlinexample.model.api.CountriesAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country

class AllCountriesRepository(private val countriesApi: CountriesAPI) : SafeApiRequest() {
    suspend fun fetchAllCountries(): List<Country> {
        val response = apiRequest { countriesApi.getAllCountries() }
       return response
    }
}