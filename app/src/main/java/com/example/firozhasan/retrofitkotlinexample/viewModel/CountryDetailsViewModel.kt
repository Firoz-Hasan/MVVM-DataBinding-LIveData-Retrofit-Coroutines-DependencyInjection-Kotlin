package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.repos.CountryDetailsRepository
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred

class CountryDetailsViewModel(private val repository : CountryDetailsRepository) : ViewModel() {
    val countryDetails by lazyDeferred {
        Log.d("hellohello","view model e asche+ ")
        repository.getCountryDetails("UM")
    }
}