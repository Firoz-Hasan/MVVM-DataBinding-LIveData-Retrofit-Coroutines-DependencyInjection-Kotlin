package com.example.firozhasan.retrofitkotlinexample.model.modelClass


import com.google.gson.annotations.SerializedName


data class RegionalBlocsItem(

	@field:SerializedName("otherNames")
	val otherNames: List<String?>? = null,

	@field:SerializedName("acronym")
	val acronym: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("otherAcronyms")
	val otherAcronyms: List<Any?>? = null
)