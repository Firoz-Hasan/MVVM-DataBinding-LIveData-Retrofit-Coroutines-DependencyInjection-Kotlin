package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.`interface`.AuthListener
import com.example.firozhasan.retrofitkotlinexample.databinding.ActivitySignInBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.UserX
import com.example.firozhasan.retrofitkotlinexample.util.hide
import com.example.firozhasan.retrofitkotlinexample.util.show
import com.example.firozhasan.retrofitkotlinexample.util.toast
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModel
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), AuthListener {


    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: UserX?) {
        progress_bar.hide()
        toast("${user?.name} is logged In")

    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)


        binding.authViewmodel = viewModel
        viewModel.authListener = this
    }
}
