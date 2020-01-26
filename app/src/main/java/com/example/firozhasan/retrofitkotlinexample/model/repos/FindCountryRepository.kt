package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firozhasan.retrofitkotlinexample.model.api.CountriesAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines

class FindCountryRepository(private val countriesAPI: CountriesAPI) : SafeApiRequest(){
    val findCountryName = MutableLiveData<String>()
    suspend fun findCountryByCapital(capital: String) {
        return Coroutines.withContextIO {
            fetchACountry(capital)
        }
    }
    private suspend fun fetchACountry(capital: String) {
        Log.d("hellohello","fetchAllCountries2 outside fetch ")
        try {
            val response = apiRequest { countriesAPI.getCountry(capital) }
            Log.d("hellohello","fetchAllCountries2inside fetch try+${response} ")
            findCountryName.postValue(response[0].name)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("hellohello","fetchAllCountries2inside fetch catch+${e.toString()} ")

        }
    }
}