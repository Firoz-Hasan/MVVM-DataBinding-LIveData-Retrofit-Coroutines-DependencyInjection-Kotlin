package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.common.MainListener
import com.example.firozhasan.retrofitkotlinexample.databinding.ItemCardBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.view.fragments.AllCountriesFrag
import com.example.firozhasan.retrofitkotlinexample.view.fragments.CountriesDetailsFrag


class CountiresAdapter(private val context: Context, val countrylist: List<Country>?) : RecyclerView.Adapter<CountiresAdapter.CountryViewHolder>() {

   /* override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CountryViewHolder {
       *//* val view = LayoutInflater.from(context).inflate(R.layout.item_card, p0, false)
        return CountryViewHolder(view)*//*


        val binding = DataBindingUtil.inflate<ItemCardBinding>(
            LayoutInflater.from(p0.context),
            R.layout.item_card,
            p0,
            false
        )
        return CountryViewHolder(binding)
    }*/
   val activity = context as Activity
    private val communicator = activity as MainListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CountryViewHolder(
                    DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.item_card,
                            parent,
                            false
                    )
            )
    override fun getItemCount(): Int {

        return countrylist?.size!!
    }

    override fun onBindViewHolder(p0: CountryViewHolder, p1: Int) {
   /*     p0.city.text = countrylist?.get(p1)?.capital
        p0.country.text = countrylist?.get(p1)?.name


        var IMAGE_URI = countrylist?.get(p1)?.flag
        GlideToVectorYou.justLoadImage(context as Activity?, Uri.parse(IMAGE_URI), p0.flag)
*/
      /*  val country = countrylist?.get(p1)
        p0.binding.country=country
       // p0.binding = country
        p0?.bind(country!!)*/
        p0.recyclerviewMovieBinding.country = this.countrylist!![p1]
    /*    p0.recyclerviewMovieBinding.itemCard1?.setOnClickListener {
            Log.d("value", "${countrylist?.get(p1)?.name}")
            communicator?.gotoDetailsFragment(countrylist?.get(p1)?.alpha2Code!!)

        }*/


    }

 /*   class CountryViewHolder(val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: Any) {

            binding.executePendingBindings()

        }
    }*/

    inner class CountryViewHolder(
        val recyclerviewMovieBinding: ItemCardBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

}