package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firozhasan.retrofitkotlinexample.model.repos.CountryDetailsRepository

class CountryDetailsViewModelFactory
(private val repository: CountryDetailsRepository):
        ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryDetailsViewModel(repository) as T
    }
}


