package com.example.firozhasan.retrofitkotlinexample.`interface`

import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User

interface AuthListener{
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}