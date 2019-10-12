package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository
import com.example.firozhasan.retrofitkotlinexample.model.repos.FindCountryRepository
import com.example.firozhasan.retrofitkotlinexample.util.lazyDeferred

class FindCountryViewModel(private val repository : FindCountryRepository)
    : ViewModel() {

    val currentCountryName: MutableLiveData<List<Country>>
        get() = repository.findCountry

    @Bindable
    val editTextCountryName = MutableLiveData<String>()

    fun onChangeFindCountryClick(view: View) {
        Log.d("hellohello", "find er view model e asche outside ")
        lazyDeferred {
            Log.d("hellohello", "find er view model e asche inside ")
            repository.findCountryByCapital(editTextCountryName.value.toString())
        }
    }

    val changeFind by lazyDeferred {
        Log.d("hellohello","view model e asche+ ")

        repository.findCountryByCapital(editTextCountryName.value.toString())

    }



}