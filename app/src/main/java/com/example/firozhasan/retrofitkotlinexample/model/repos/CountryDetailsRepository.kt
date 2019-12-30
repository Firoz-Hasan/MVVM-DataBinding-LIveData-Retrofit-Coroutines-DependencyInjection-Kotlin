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
    val detailsCountry = MutableLiveData<String>()
    val detailsCapital = MutableLiveData<String>()
    val detailsArea = MutableLiveData<String>()
    val detailsPopulation = MutableLiveData<String>()
    val detailsRegion = MutableLiveData<String>()
    val detailsTimezone = MutableLiveData<String>()
    val detailsCurrency = MutableLiveData<String>()
    val detailsLanguage = MutableLiveData<String>()


    suspend fun getCountryDetails(alpha2Code: String): LiveData<List<Country>> {
        return withContext(Dispatchers.IO) {
            fetchCountryDetails(alpha2Code)
            // db.getQuoteDao().getQuotes()
            findCountryFullInfo
        }

    }


    private suspend fun fetchCountryDetails(alpha2Code: String) {
        //val lastSavedAt = prefs.getLastSavedAt()
        Log.d("hellohello","fetchCountryDetails outside fetch ")
        try {
            val response = apiRequest { countriesAPI.getCountryDetails(alpha2Code) }
            detailsCapital.postValue(response.capital)
            detailsCountry.postValue(response.name)
            detailsArea.postValue(response.area.toString())
            detailsPopulation.postValue(response.population.toString())
            detailsRegion.postValue(response.region)
            detailsTimezone.postValue(response.timezones!![0])
            detailsCurrency.postValue(response.currencies!![0]?.name)
            detailsLanguage.postValue(response.languages!![0]?.name)

            Log.d("hellohello","fetchCountryDetails fetch try+${response} ")
            //findCountryFullInfo.postValue(response)
            //findCountryName.postValue(response[0].name)

        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("hellohello","fetchAllCountries2inside fetch catch+${e.toString()} ")

        }

    }
}