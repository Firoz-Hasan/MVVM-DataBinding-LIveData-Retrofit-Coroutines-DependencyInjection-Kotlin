package com.example.firozhasan.retrofitkotlinexample.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.databinding.FragmentSearchFragBinding
import com.example.firozhasan.retrofitkotlinexample.viewModel.CountryViewModel

/**
 * A simple [Fragment] subclass.
 */
class Search_frag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val viewModel = ViewModelProviders.of(this)
            .get(CountryViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentSearchFragBinding>(inflater,
            R.layout.fragment_search_frag, container, false).apply {
            this.lifecycleOwner = activity
            this.viewmodel = viewModel
        }
        return binding.root
    }


}
