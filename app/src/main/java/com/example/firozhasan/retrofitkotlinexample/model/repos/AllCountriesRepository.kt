package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firozhasan.retrofitkotlinexample.model.api.CountriesAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country

class AllCountriesRepository(private val countriesApi: CountriesAPI) : SafeApiRequest() {
    val allCountires = MutableLiveData<List<Country>>()
    /*   suspend fun getALLCounty2(): MutableLiveData<List<Country>> {
           return withContext(Dispatchers.IO) {
               fetchAllCountries2()
               // db.getQuoteDao().getQuotes()
               allCountires
           }
       }*/
    suspend fun fetchAllCountries2(): List<Country> {
        Log.d("hellohello", "fetchAllCountries2 outside fetch ")
        val response = apiRequest { countriesApi.getAllCountries() }
        allCountires.postValue(response)
        Log.d("hellohello", "fetchAllCountries2inside fetch try+${allCountires} ")
        return response
    }
}