package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.arch.lifecycle.ViewModel
import android.view.View
import com.example.firozhasan.retrofitkotlinexample.`interface`.AuthListener
import com.example.firozhasan.retrofitkotlinexample.model.repos.Repository

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
        val loginResponse = Repository.userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }


}