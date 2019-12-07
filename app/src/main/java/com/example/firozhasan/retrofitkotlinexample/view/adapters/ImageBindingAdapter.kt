package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    /* Glide.with(view)
         .load(url)
         .into(view)
     Log.d("ttt", url)*/

    GlideToVectorYou.justLoadImage(view.context as Activity?, Uri.parse(url), view)

}