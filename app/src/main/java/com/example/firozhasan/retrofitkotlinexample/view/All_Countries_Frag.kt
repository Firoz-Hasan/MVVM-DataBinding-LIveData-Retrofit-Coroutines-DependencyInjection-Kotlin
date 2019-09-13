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
class All_Countries_Frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all__countries_, container, false)
    }


}
