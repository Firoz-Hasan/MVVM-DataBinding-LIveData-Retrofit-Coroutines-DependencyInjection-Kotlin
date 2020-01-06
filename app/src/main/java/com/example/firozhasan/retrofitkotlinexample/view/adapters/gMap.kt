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
          //latLng =   LatLng(60.116667, 19.9)
       Log.d("ubububua", "asche1 = ${latLng?.latitude} and ${latLng?.longitude}")

            val markerOptions = MarkerOptions()

            if (latLng?.latitude != null) {
                markerOptions.position(LatLng(latLng?.latitude!!, latLng?.longitude!!))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latLng?.latitude!!, latLng?.longitude!!), 4f))
                googleMap.addMarker(markerOptions)
            }
            else {
                /*markerOptions.position(LatLng(52.4912, -1.9348))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(52.4912, -1.9348), 4f))
                googleMap.addMarker(markerOptions)*/
            }
        })
    }
}