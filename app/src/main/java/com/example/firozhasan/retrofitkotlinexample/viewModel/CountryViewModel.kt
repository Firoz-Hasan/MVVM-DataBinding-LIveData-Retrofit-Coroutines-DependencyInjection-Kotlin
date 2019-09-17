package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import com.example.firozhasan.retrofitkotlinexample.model.repos.Repository

class CountryViewModel : ViewModel() {

    val currentCountryName: LiveData<String>
        get() = Repository.currentCountryName


    @Bindable
    val editTextCountryName = MutableLiveData<String>()

    fun onChangeFindCountryClick() = Repository.getCountyNameByCapital(editTextCountryName.value.toString())

   // fun onChangeFindCountryClick() = Repository.getALLCounty()


}