package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firozhasan.retrofitkotlinexample.model.api.CountriesAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AllCountriesRepository(private val countriesApi: CountriesAPI) : SafeApiRequest(){

   // private val quotes = MutableLiveData<List<Quote>>()
    private val allCountires = MutableLiveData<List<Country>>()
    init {
        allCountires.observeForever {
           // saveQuotes(it)
           // fetchAllCountries2()
        }
    }

    private fun saveQuotes(allcountries: List<Country>?) {


    }


    suspend fun getALLCounty2(): LiveData<List<Country>> {
        return withContext(Dispatchers.IO) {
            fetchAllCountries2()
            // db.getQuoteDao().getQuotes()
            allCountires
        }
    }


    private suspend fun fetchAllCountries2() {
        //val lastSavedAt = prefs.getLastSavedAt()
        Log.d("hellohello","fetchAllCountries2 outside fetch ")
            try {
                val response = apiRequest { countriesApi.getAllCountries() }
                Log.d("hellohello","fetchAllCountries2inside fetch try+${response} ")
                allCountires.postValue(response)

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("hellohello","fetchAllCountries2inside fetch catch+${e.toString()} ")

            }

    }
}