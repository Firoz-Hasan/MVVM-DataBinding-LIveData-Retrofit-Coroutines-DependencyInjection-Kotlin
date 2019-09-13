package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountiresAdapter(private val context: Context, val countrylist: List<Country>?) : RecyclerView.Adapter<CountiresAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card, p0, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {

        return countrylist?.size!!
    }

    override fun onBindViewHolder(p0: CountryViewHolder, p1: Int) {
        p0.city.text = countrylist?.get(p1)?.capital
        p0.country.text = countrylist?.get(p1)?.name


        var IMAGE_URI = countrylist?.get(p1)?.flag
        GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(IMAGE_URI), p0.flag)




        Log.d("value", "${countrylist?.get(p1)?.flag}")
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var flag: ImageView = itemView.findViewById(R.id.flag_imv)
        var country: TextView = itemView.findViewById(R.id.country_tv)
        var city: TextView = itemView.findViewById(R.id.city_tv)

    }

}