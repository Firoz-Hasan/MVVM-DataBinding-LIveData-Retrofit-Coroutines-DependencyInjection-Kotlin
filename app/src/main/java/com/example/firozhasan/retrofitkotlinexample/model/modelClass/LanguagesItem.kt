package com.example.firozhasan.retrofitkotlinexample.model.modelClass

import com.google.gson.annotations.SerializedName


data class LanguagesItem(

	@field:SerializedName("nativeName")
	val nativeName: String? = null,

	@field:SerializedName("iso639_2")
	val iso6392: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("iso639_1")
	val iso6391: String? = null
)