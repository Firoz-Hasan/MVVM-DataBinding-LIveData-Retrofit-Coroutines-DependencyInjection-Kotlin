package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.countryRepos

class AllCountiresViewModel : ViewModel() {
     val allCountires: LiveData<List<Country>>
        get() = countryRepos.countires

    fun onChangeFindCountryClick() = countryRepos.getALLCounty()



}