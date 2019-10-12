package com.example.firozhasan.retrofitkotlinexample.view.fragments


import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.databinding.FragmentSearchFragBinding
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountriesViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.CountryViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.FindCountryViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.FindCountryViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

/**
 * A simple [Fragment] subclass.
 */
class SearchFrag : Fragment(),KodeinAware {

    private lateinit var viewModel: FindCountryViewModel
    override val kodein by kodein()
    private val factory: FindCountryViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       //val viewModel = ViewModelProviders.of(this).get(FindCountryViewModel::class.java)

        viewModel = ViewModelProviders.of(this, factory).get(FindCountryViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentSearchFragBinding>(inflater,
            R.layout.fragment_search_frag, container, false).apply {
            this.lifecycleOwner = activity
            this.viewmodel = viewModel
        }
        return binding.root
    }


}
