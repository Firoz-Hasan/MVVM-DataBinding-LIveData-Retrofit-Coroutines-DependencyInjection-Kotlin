package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import com.example.firozhasan.retrofitkotlinexample.model.repos.countryRepos

class CountryViewModel : ViewModel() {

    val currentCountryName: LiveData<String>
        get() = countryRepos.currentCountryName


    @Bindable
    val editTextCountryName = MutableLiveData<String>()

    fun onChangeFindCountryClick() = countryRepos.getCountyNameByCapital(editTextCountryName.value.toString())


}