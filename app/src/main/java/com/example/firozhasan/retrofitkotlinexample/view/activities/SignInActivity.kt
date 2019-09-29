package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.`interface`.AuthListener
import com.example.firozhasan.retrofitkotlinexample.databinding.ActivitySignInBinding
import com.example.firozhasan.retrofitkotlinexample.model.api.LoginAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.NetworkConnectionInterceptor
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.UserX
import com.example.firozhasan.retrofitkotlinexample.model.repos.LoginRepository
import com.example.firozhasan.retrofitkotlinexample.util.hide
import com.example.firozhasan.retrofitkotlinexample.util.show
import com.example.firozhasan.retrofitkotlinexample.util.snackbar
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModelFactory
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), AuthListener {


    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: UserX?) {
        progress_bar.hide()
        signIN_LL?.snackbar("${user?.name} is logged In")
      //  toast("${user?.name} is logged In")

    }

    override fun onFailure(message: String) {
        signIN_LL?.snackbar(message)
        progress_bar.hide()
     //   toast(message)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val loginAPI = LoginAPI(networkConnectionInterceptor)
        val loginRepository = LoginRepository(loginAPI)
        val factory = AuthViewModelFactory(loginRepository)


        val binding: ActivitySignInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)


        binding.authViewmodel = viewModel
        viewModel.authListener = this
    }
}
