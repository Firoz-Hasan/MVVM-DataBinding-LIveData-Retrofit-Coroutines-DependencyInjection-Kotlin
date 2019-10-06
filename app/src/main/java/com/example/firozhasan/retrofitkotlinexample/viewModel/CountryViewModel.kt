package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.Bindable
import com.example.firozhasan.retrofitkotlinexample.model.repos.Repository

class CountryViewModel : ViewModel() {

    val currentCountryName: LiveData<String>
        get() = Repository.currentCountryName


    @Bindable
    val editTextCountryName = MutableLiveData<String>()

    fun onChangeFindCountryClick() = Repository.getCountyNameByCapital(editTextCountryName.value.toString())

   // fun onChangeFindCountryClick() = Repository.getALLCounty()


}