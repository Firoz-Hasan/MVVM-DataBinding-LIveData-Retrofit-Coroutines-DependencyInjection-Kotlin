package com.example.firozhasan.retrofitkotlinexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firozhasan.retrofitkotlinexample.model.repos.LoginRepository

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
    private val repository: LoginRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}