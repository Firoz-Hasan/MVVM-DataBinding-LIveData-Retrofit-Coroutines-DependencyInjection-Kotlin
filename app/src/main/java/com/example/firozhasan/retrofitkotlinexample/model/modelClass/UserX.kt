package com.example.firozhasan.retrofitkotlinexample.model.modelClass


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("email_verified_at")
    var emailVerifiedAt: Any = Any(),
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("updated_at")
    var updatedAt: String = ""
)