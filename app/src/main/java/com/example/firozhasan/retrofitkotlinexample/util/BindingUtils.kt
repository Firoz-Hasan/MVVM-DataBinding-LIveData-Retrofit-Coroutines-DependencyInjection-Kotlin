package com.example.firozhasan.retrofitkotlinexample.util

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.firozhasan.retrofitkotlinexample.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
//import com.squareup.picasso.Picasso


//import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

/*@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
            .load(url)
            .into(view)
}*/

@BindingAdapter("image")
fun loadImage(view : ImageView, url : String){
    //GlideToVectorYou.justLoadImage(view.context as Activity?, Uri.parse(url), view)
   /* Picasso.get().load(url).fit()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(view)*/

    Glide.with(view)
        .load(url)
        .into(view)

}



