package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firozhasan.retrofitkotlinexample.model.api.CountriesAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryDetailsRepository (private val countriesAPI: CountriesAPI) : SafeApiRequest() {


    val findCountryFullInfo = MutableLiveData<List<Country>>()
    val findCountryName = MutableLiveData<String>()

    suspend fun getCountryDetails(alpha2Code: String): LiveData<List<Country>> {
        return withContext(Dispatchers.IO) {
            fetchCountryDetails(alpha2Code)
            // db.getQuoteDao().getQuotes()
            findCountryFullInfo
        }

    }


    private suspend fun fetchCountryDetails(alpha2Code: String) {
        //val lastSavedAt = prefs.getLastSavedAt()
        Log.d("hellohello","fetchAllCountries2 outside fetch ")
        try {
            val response = apiRequest { countriesAPI.getCountryDetails(alpha2Code) }
            Log.d("hellohello","fetchAllCountries2inside fetch try+${response} ")
            //findCountryFullInfo.postValue(response)
            //findCountryName.postValue(response[0].name)

        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("hellohello","fetchAllCountries2inside fetch catch+${e.toString()} ")

        }

    }
}