package com.example.firozhasan.retrofitkotlinexample.`interface`

import android.arch.lifecycle.LiveData
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User

interface AuthListener{
    fun onStarted()
    fun onSuccess(loginResponse : LiveData<String>)
    fun onFailure(message: String)
}