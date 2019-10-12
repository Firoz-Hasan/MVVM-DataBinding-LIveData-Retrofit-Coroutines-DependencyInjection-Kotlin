package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
       // Glide.with(view.context).load(url).into(view)
        GlideToVectorYou.justLoadImage(view.context as Activity?, Uri.parse(url), view)

    }
}