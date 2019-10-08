package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred

class AllCountiresViewModel(private val repository : AllCountriesRepository)
    : ViewModel() {
    /* val allCountires: LiveData<List<Country>>
        get() = Repository.getAllCountires

    fun onChangeFindCountryClick() = Repository.getALLCounty()*/

    val allcountries by lazyDeferred {
        repository.fetchAllCountries()
    }



}