package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    /* Glide.with(view)
         .load(url)
         .into(view)
     Log.d("ttt", url)*/

    GlideToVectorYou.justLoadImage(view.context as Activity?, Uri.parse(url), view)

}

@BindingAdapter("list")
fun bindUsersRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
    val adapter = recyclerView.adapter as CountriesAdapter2
    data?.let {
        adapter.submitList(data)
    }
}
