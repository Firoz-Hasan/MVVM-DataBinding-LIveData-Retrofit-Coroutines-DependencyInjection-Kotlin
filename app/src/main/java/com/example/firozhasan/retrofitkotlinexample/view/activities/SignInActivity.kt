package com.example.firozhasan.retrofitkotlinexample.view.activities

import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.common.AuthListener
import com.example.firozhasan.retrofitkotlinexample.databinding.ActivitySignInBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.UserX
import com.example.firozhasan.retrofitkotlinexample.util.hide
import com.example.firozhasan.retrofitkotlinexample.util.show
import com.example.firozhasan.retrofitkotlinexample.util.snackbar
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModelFactory
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class SignInActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    override fun gotoMainActivity() {
        Intent(this, MainActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }


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


        val binding: ActivitySignInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)


        binding.authViewmodel = viewModel
        viewModel.authListener = this


    }
}

