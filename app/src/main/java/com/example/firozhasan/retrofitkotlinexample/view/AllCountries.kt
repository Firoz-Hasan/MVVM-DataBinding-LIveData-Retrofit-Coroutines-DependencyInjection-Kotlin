package com.example.firozhasan.retrofitkotlinexample.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountiresAdapter
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountiresViewModel

class AllCountries : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CountiresAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_countries)

        recyclerView = findViewById(R.id.countries_RV)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mainViewModel = ViewModelProviders.of(this)
                .get(AllCountiresViewModel::class.java)
        mainViewModel.onChangeFindCountryClick()

        /*mainViewModel.allCountires.observe(this, Observer {
            adapter = CountiresAdapter(this, heroList)
            recyclerView.setAdapter(adapter)
        })*/

        mainViewModel.allCountires.observe(this, Observer<List<Country>> { t ->
            adapter = CountiresAdapter(this@AllCountries, t)
            recyclerView.adapter = adapter
        })

    }

}
