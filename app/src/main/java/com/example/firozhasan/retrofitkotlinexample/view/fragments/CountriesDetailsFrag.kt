package com.example.firozhasan.retrofitkotlinexample.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.databinding.CountryDetailFragBinding
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines
import com.example.firozhasan.retrofitkotlinexample.viewModel.CountryDetailsViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.CountryDetailsViewModelFactory
import com.google.android.gms.maps.model.LatLng
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class CountriesDetailsFrag: Fragment(), KodeinAware {
    private lateinit var viewModel: CountryDetailsViewModel
    override val kodein by kodein()
    private val factory: CountryDetailsViewModelFactory by instance()
    var alphaValue = "empty"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         //alphaValue = arguments!!.getString("alpha")

                val bundle = this.arguments
                val myValue = bundle!!.getString("message")
        Log.d("alhabibi", "yaalpha = $myValue")
                alphaValue = myValue
                Log.d("fraglifecycle", "oncreateview")
        viewModel = ViewModelProviders.of(this, factory).get(CountryDetailsViewModel::class.java)
        val binding = DataBindingUtil.inflate<CountryDetailFragBinding>(inflater,
                R.layout.country_detail_frag, container, false).apply {
            this.lifecycleOwner = activity
            this.viewmodel = viewModel
            bindUI()

        }

        //Toast.makeText(activity,"sfsdfsf",Toast.LENGTH_LONG).show()
        return binding.root
       // return inflater.inflate(R.layout.fragment_search_frag, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this, factory).get(CountryDetailsViewModel::class.java)
        Log.d("fraglifecycle", "onActivityCreated")



    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("fraglifecycle", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fraglifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("fraglifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("fraglifecycle", "onResume")
    }


    private fun bindUI() = Coroutines.main {
        //progressBar.show()
        viewModel.alpha2CountryDetails(alphaValue)


    }
}