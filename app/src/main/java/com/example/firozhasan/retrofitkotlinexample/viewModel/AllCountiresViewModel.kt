package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.Repository

class AllCountiresViewModel : ViewModel() {
     val allCountires: LiveData<List<Country>>
        get() = Repository.getAllCountires

    fun onChangeFindCountryClick() = Repository.getALLCounty()



}