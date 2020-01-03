package com.example.firozhasan.retrofitkotlinexample.view.fragments

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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class CountriesDetailsFrag: Fragment(), KodeinAware, OnMapReadyCallback {
    var mapFragment: SupportMapFragment? = null
    var globalLatLng: LatLng? = null

    private lateinit var viewModel: CountryDetailsViewModel
    override val kodein by kodein()
    private val factory: CountryDetailsViewModelFactory by instance()
    var alphaValue = "empty"
    var latLng = LatLng(33.0, 65.0)
            //LatLng(viewModel.lat,viewModel.lng)
    //globalLatLng = latLng
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         alphaValue = arguments!!.getString("alpha")
        Log.d("alhabibi", "yaalpha = $alphaValue")

        viewModel = ViewModelProviders.of(this, factory).get(CountryDetailsViewModel::class.java)
        val binding = DataBindingUtil.inflate<CountryDetailFragBinding>(inflater,
                R.layout.country_detail_frag, container, false).apply {
            this.lifecycleOwner = activity
            this.viewmodel = viewModel
            //bindUI()

        }

        //Toast.makeText(activity,"sfsdfsf",Toast.LENGTH_LONG).show()
        return binding.root
       // return inflater.inflate(R.layout.fragment_search_frag, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this, factory).get(CountryDetailsViewModel::class.java)




    }

    private fun bindUI() = Coroutines.main {
        //progressBar.show()
        viewModel.alpha2CountryDetails(alphaValue)

        prepareMap()


    }

    fun prepareMap() {
        //mapFragment = support.findFragmentById(R.id.map) as SupportMapFragment
       // mapFragment!!.getMapAsync(this)

        if (activity != null) {
             mapFragment = activity!!.supportFragmentManager
                    .findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(this)

        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        Log.d("alhabibi", "yaalpha = $latLng")
        placeMarker(p0!!,latLng!!)
    }

    // place marker on the country geo graphic location
    fun placeMarker(googleMap: GoogleMap, latLng: LatLng) {
        Log.d("alhabibi", "yaalpha = $latLng")
        val markerOptions = MarkerOptions()
        markerOptions.position(latLng)
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,4f))
        googleMap.addMarker(markerOptions)
    }
}