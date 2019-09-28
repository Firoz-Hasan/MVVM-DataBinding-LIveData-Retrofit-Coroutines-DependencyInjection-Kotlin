package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.arch.lifecycle.ViewModel
import android.view.View
import com.example.firozhasan.retrofitkotlinexample.`interface`.AuthListener
import com.example.firozhasan.retrofitkotlinexample.model.repos.Repository
import com.example.firozhasan.retrofitkotlinexample.util.ApiException
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines

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
        Coroutines.main {
          try {
              val loginResponse = Repository.userLogin(email!!, password!!)
              loginResponse?.user?.let {
                  authListener?.onSuccess(it)

              }
              

          }
          catch (e : ApiException){
              authListener?.onFailure(e.message!!)
          }

        }

    }


}