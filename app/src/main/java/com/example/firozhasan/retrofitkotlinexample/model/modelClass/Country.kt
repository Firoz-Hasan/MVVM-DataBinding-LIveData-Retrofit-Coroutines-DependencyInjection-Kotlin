package com.example.firozhasan.retrofitkotlinexample.model.modelClass


import com.google.gson.annotations.SerializedName

data class Country(

	@field:SerializedName("area")
	val area: Int? = null,

	@field:SerializedName("nativeName")
	val nativeName: String? = null,

	@field:SerializedName("capital")
	val capital: String? = null,

	@field:SerializedName("demonym")
	val demonym: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("alpha2Code")
	val alpha2Code: String? = null,

	@field:SerializedName("languages")
	val languages: List<LanguagesItem?>? = null,

	@field:SerializedName("borders")
	val borders: List<String?>? = null,

	@field:SerializedName("subregion")
	val subregion: String? = null,

	@field:SerializedName("callingCodes")
	val callingCodes: List<String?>? = null,

	@field:SerializedName("regionalBlocs")
	val regionalBlocs: List<RegionalBlocsItem?>? = null,

	@field:SerializedName("gini")
	val gini: Double? = null,

	@field:SerializedName("population")
	val population: Int? = null,

	@field:SerializedName("numericCode")
	val numericCode: String? = null,

	@field:SerializedName("alpha3Code")
	val alpha3Code: String? = null,

	@field:SerializedName("topLevelDomain")
	val topLevelDomain: List<String?>? = null,

	@field:SerializedName("timezones")
	val timezones: List<String?>? = null,

	@field:SerializedName("cioc")
	val cioc: String? = null,

	@field:SerializedName("translations")
	val translations: Translations? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("altSpellings")
	val altSpellings: List<String?>? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("latlng")
	val latlng: List<Int?>? = null,

	@field:SerializedName("currencies")
	val currencies: List<CurrenciesItem?>? = null
)