package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.repos.CountryDetailsRepository
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred
import com.google.android.gms.maps.model.LatLng

class CountryDetailsViewModel(private val repository : CountryDetailsRepository) : ViewModel() {
    var alpha2Code: String? = null

    val capital: LiveData<String>
        get() = repository.detailsCapital

    val country: LiveData<String>
        get() = repository.detailsCountry

    val area: LiveData<String>
        get() = repository.detailsArea

    val population: LiveData<String>
        get() = repository.detailsPopulation
    val region: LiveData<String>
        get() = repository.detailsRegion

    val timezone: LiveData<String>
        get() = repository.detailsTimezone

    val currency: LiveData<String>
        get() = repository.detailsCurrency
    val language: LiveData<String>
        get() = repository.detailsLanguage

val flag: LiveData<String>
        get() = repository.detailsFlag

    val lat: LiveData<LatLng>
        get() = repository.detailsLat
    val lng: LiveData<LatLng>
        get() = repository.detailsLng



    suspend fun alpha2CountryDetails(alpha : String) {
        Coroutines.main {
            Log.d("hellohello", "alpha2CountryDetails = ${alpha} ")
            repository.getCountryDetails(alpha)
        }
    }

    val countryDetails by lazyDeferred {
        Log.d("hellohello","view model e asche+ ")
        repository.getCountryDetails("AR")
    }
}