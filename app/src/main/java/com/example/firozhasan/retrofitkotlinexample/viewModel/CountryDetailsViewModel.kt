package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.repos.CountryDetailsRepository
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred

class CountryDetailsViewModel(private val repository : CountryDetailsRepository) : ViewModel() {
    var alpha2Code: String? = null

    val capital: LiveData<String>
        get() = repository.detailsCapitalName

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