package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.view.fragments.CountriesDetailsFrag


class CountryDetails : AppCompatActivity() {

    var countriesDetails: CountriesDetailsFrag? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country__details)
        countriesDetails = CountriesDetailsFrag()
        val getAlphaCode = intent.getStringExtra("alpha")
        val bundle = Bundle()
        bundle.putString("message", getAlphaCode)
        countriesDetails!!.setArguments(bundle)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                 .add(R.id.cntryDetails, countriesDetails!!)
                .show(countriesDetails!!)
                .commit()
    }
}
