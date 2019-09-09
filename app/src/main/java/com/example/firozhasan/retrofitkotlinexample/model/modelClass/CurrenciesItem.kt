package com.example.firozhasan.retrofitkotlinexample.model.modelClass


import com.google.gson.annotations.SerializedName


data class CurrenciesItem(

	@field:SerializedName("symbol")
	val symbol: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)