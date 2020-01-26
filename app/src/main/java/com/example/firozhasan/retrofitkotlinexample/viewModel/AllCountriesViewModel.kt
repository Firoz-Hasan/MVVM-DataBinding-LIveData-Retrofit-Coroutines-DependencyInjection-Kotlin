package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository
import com.example.firozhasan.retrofitkotlinexample.util.Status
import kotlinx.coroutines.launch

class AllCountriesViewModel(private val repository : AllCountriesRepository)
    : ViewModel() {
    private var countryList: List<Country>? = null
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>?
        get() = _countries
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
}