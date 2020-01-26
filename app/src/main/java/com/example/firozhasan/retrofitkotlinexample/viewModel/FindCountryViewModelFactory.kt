package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firozhasan.retrofitkotlinexample.model.repos.FindCountryRepository

@Suppress("UNCHECKED_CAST")
class FindCountryViewModelFactory(
    private val repository: FindCountryRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FindCountryViewModel(repository) as T
    }
}