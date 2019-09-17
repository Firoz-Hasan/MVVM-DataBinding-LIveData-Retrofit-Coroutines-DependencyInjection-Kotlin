package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.databinding.AllCountriesFragBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country

import com.example.firozhasan.retrofitkotlinexample.databinding.ItemCardBinding

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
        p0?.bind(country!!)



  /*      holder.binding.setItemClick({ f ->
            val intent = Intent(context, DetailseActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("Movie", movie)
            context.startActivity(intent)
        })*/



        Log.d("value", "${countrylist?.get(p1)?.flag}")
    }

/*    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder() {

        var flag: ImageView = itemView.findViewById(R.id.flag_imv)
        var country: TextView = itemView.findViewById(R.id.country_tv)
        var city: TextView = itemView.findViewById(R.id.city_tv)

    }*/

    class CountryViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: Any) {
            binding.executePendingBindings()
        }
    }

}