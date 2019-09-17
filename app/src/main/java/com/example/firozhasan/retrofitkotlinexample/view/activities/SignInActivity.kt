package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.`interface`.AuthListener
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User

class SignInActivity : AppCompatActivity(), AuthListener {
    override fun onStarted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }
}
