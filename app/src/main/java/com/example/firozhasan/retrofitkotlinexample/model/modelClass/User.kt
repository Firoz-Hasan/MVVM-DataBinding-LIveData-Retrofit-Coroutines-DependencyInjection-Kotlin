package com.example.firozhasan.retrofitkotlinexample.model.modelClass


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("isSuccessful")
    var isSuccessful: Boolean = false,
    @SerializedName("message")
    var message: String = "",
    @SerializedName("user")
    var user: UserX = UserX()
)