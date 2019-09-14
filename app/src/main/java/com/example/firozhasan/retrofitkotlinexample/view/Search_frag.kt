package com.example.firozhasan.retrofitkotlinexample.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.firozhasan.retrofitkotlinexample.R

/**
 * A simple [Fragment] subclass.
 */
class Search_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.find_country_frag, container, false)
    }


}
