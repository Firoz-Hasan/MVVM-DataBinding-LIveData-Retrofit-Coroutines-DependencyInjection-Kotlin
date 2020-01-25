package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository
import com.example.firozhasan.retrofitkotlinexample.util.Status
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred
import com.example.firozhasan.retrofitkotlinexample.view.activities.CountryDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCountriesViewModel(private val repository : AllCountriesRepository)
    : ViewModel() {

    private var countryList: List<Country>? = null
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>?
        get() = _countries

    val countryList2: LiveData<List<Country>>
        get() = repository.allCountires

    private val _navigateToCountryDetails = MutableLiveData<Country>()
    val navigateToCountryDetails : LiveData<Country>
        get() = _navigateToCountryDetails


    private val _navigateAlpha2Code = MutableLiveData<String>()
    val navigateAlpha2Code : LiveData<String>
        get() = _navigateAlpha2Code

    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status>
        get() = _status


    init {
        getCountry()
    }
    private fun getCountry() {
        viewModelScope.launch {
            try {
                countryList = repository.fetchAllCountries2()
                _status.value = Status.LOADING
                _countries.value = countryList
                _status.value = Status.DONE
                Log.d("pakapaki","fetchAllCountries2inside fetch try+${_countries?.value} ")

            } catch (e: Exception) {
                _status.value = Status.ERROR
                e.printStackTrace()

            }
        }
    }

    fun displayCountryDetails(country: Country)
    {
        Log.d("clclcl","${country.alpha2Code} ")
        _navigateAlpha2Code.value = country.alpha2Code


    }






}