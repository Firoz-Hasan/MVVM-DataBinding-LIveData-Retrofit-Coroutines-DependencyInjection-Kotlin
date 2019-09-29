package com.example.firozhasan.retrofitkotlinexample.model.repos

import com.example.firozhasan.retrofitkotlinexample.model.api.LoginAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.SafeApiRequest
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User

class LoginRepository(private val loginAPI: LoginAPI) : SafeApiRequest(){

    suspend fun userLogin(email: String, password: String): User {
        return apiRequest { loginAPI.userLogin(email, password) }

    }
}