package com.example.firozhasan.retrofitkotlinexample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.firozhasan.retrofitkotlinexample.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     /*   val mainViewModel = ViewModelProviders.of(this)
                .get(CountryViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel = mainViewModel
        }*/


    }





}

