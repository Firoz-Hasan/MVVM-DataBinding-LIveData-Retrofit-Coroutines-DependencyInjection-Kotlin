package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.databinding.ItemCardBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country

class CountiresAdapter(private val context: Context, val countrylist: List<Country>?) : RecyclerView.Adapter<CountiresAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CountryViewHolder {
       /* val view = LayoutInflater.from(context).inflate(R.layout.item_card, p0, false)
        return CountryViewHolder(view)*/


        val binding = DataBindingUtil.inflate<ItemCardBinding>(
            LayoutInflater.from(p0.context),
            R.layout.item_card,
            p0,
            false
        )
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return countrylist?.size!!
    }

    override fun onBindViewHolder(p0: CountryViewHolder, p1: Int) {
   /*     p0.city.text = countrylist?.get(p1)?.capital
        p0.country.text = countrylist?.get(p1)?.name


        var IMAGE_URI = countrylist?.get(p1)?.flag
        GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(IMAGE_URI), p0.flag)
*/
        val country = countrylist?.get(p1)
        p0.binding.country=country
       // p0.binding = country
        p0?.bind(country!!)

        Log.d("value", "${countrylist?.get(p1)?.flag}")
    }

    class CountryViewHolder(val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: Any) {

            binding.executePendingBindings()

        }
    }

}