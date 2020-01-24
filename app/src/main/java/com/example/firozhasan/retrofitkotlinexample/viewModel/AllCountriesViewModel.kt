package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCountriesViewModel(private val repository : AllCountriesRepository)
    : ViewModel() {

    val allcountries by lazyDeferred {
        Log.d("hellohello","view model e asche+ ")
        repository.getALLCounty2()
    }

    private var countryList: List<Country>? = null


    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>?
        get() = _countries

    val countryList2: LiveData<List<Country>>
        get() = repository.allCountires


    init {
        getCountry()
    }
    fun getCountry() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    countryList = repository.fetchAllCountries2()
                }

                _countries.value = countryList
                Log.d("pakapaki","fetchAllCountries2inside fetch try+${_countries?.value} ")

//                Timber.i("$userList")

            } catch (e: Exception) {
                e.printStackTrace()

            }
        }
    }






}