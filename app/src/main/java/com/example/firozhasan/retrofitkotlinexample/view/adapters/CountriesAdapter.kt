package com.example.firozhasan.retrofitkotlinexample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.databinding.ItemCardBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country

class CountriesAdapter(val clickListener: CountryListener) :  ListAdapter<Country, CountriesAdapter.CountryViewHolder>(DiffUserCallback){

    companion object DiffUserCallback : DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

    }

    class CountryViewHolder(private var binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root){

        companion object {
            fun from(parent: ViewGroup) : CountryViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCardBinding.inflate(layoutInflater,parent,false)
                return CountryViewHolder(binding)
            }
        }

        fun bind(
                country: Country,
                clickListener: CountryListener
        ){
            binding.country = country
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder.from(parent)}

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country,clickListener)
    }

}

class CountryListener(val clickListener : (country : Country) -> Unit){
    fun onClick(country: Country) = clickListener(country)
}