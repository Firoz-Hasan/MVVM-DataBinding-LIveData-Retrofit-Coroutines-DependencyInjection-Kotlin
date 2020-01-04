package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.os.Bundle
import android.util.Log
import androidx.databinding.BindingAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@BindingAdapter("initMap")
fun initMap(mapView: MapView?, latLng: LatLng?) {
    if (mapView != null) {
        mapView.onCreate(Bundle())
        mapView.getMapAsync(OnMapReadyCallback { googleMap ->
            // Add a marker
          //  googleMap.addMarker(MarkerOptions().position(latLng!!).title("Marker in India"))
       Log.d("ubububua", "asche")

            val markerOptions = MarkerOptions()
            markerOptions.position(LatLng(33.0, 65.0))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(33.0, 65.0),4f))
            googleMap.addMarker(markerOptions)
        })
    }
}