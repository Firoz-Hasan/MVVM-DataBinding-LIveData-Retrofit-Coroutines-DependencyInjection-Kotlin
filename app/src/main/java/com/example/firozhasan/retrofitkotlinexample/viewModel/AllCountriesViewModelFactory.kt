package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository

@Suppress("UNCHECKED_CAST")
class AllCountriesViewModelFactory(
    private val repository: AllCountriesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCountriesViewModel(repository) as T
    }
}