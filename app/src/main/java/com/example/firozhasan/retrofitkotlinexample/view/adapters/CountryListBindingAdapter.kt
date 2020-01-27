package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.app.Activity
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.util.Status
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    /* Glide.with(view)
         .load(url)
         .into(view)
     Log.d("ttt", url)*/
    GlideToVectorYou.justLoadImage(view.context as Activity?, Uri.parse(url), view)

}

@BindingAdapter("list")
fun bindCountryRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
    val adapter = recyclerView.adapter as CountriesAdapter
    data?.let {
        adapter.submitList(data)
    }
}

@BindingAdapter("progressbarStatus")
fun showHideProgressbar(progressBar: ProgressBar, countryStatus: Status?) {
    when (countryStatus) {
        Status.LOADING -> {
            progressBar.visibility = View.VISIBLE
        }
        Status.DONE -> {
            progressBar.visibility = View.INVISIBLE
        }
        Status.ERROR->{
            progressBar.visibility = View.VISIBLE
        }
        else ->
            progressBar.visibility = View.VISIBLE
    }
}
