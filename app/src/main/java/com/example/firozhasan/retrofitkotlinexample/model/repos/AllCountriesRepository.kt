package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firozhasan.retrofitkotlinexample.model.api.CountiresAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AllCountriesRepository(private val countriesApi: CountiresAPI) : SafeApiRequest(){

   // private val quotes = MutableLiveData<List<Quote>>()
    private val allCountires = MutableLiveData<List<Country>>()
    init {
        allCountires.observeForever {
            saveQuotes(it)
        }
    }

    private fun saveQuotes(allcountries: List<Country>?) {

    }


     suspend fun fetchAllCountries() {


          try {
                val response = apiRequest { countriesApi.getAllCountries() }
                allCountires.postValue(response)
               } catch (e: Exception) {
                e.printStackTrace()
            }

    }

    suspend fun getALLCounty(): List<Country> {
        return apiRequest { countriesApi.getAllCountries() }
    }
}