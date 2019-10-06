package com.example.firozhasan.retrofitkotlinexample.view.fragments


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountiresAdapter
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountiresViewModel

/**
 * A simple [Fragment] subclass.
 */
class All_Countries_Frag : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CountiresAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.all_countries_frag, container, false)

        recyclerView = view?.findViewById(R.id.countries_RV)!!
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val mainViewModel = ViewModelProviders.of(this)
            .get(AllCountiresViewModel::class.java)
        mainViewModel.onChangeFindCountryClick()
        mainViewModel.allCountires.observe(this, Observer<List<Country>> { t ->
            adapter = CountiresAdapter(activity!!, t)
            recyclerView.adapter = adapter
        })
        return view
    }


}
