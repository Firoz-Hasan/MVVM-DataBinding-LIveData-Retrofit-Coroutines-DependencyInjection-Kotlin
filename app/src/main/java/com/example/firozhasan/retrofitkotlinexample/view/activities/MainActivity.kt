package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.common.MainListener
import com.example.firozhasan.retrofitkotlinexample.util.toast
import com.example.firozhasan.retrofitkotlinexample.view.fragments.AllCountriesFrag
import com.example.firozhasan.retrofitkotlinexample.view.fragments.CountriesDetailsFrag
import com.example.firozhasan.retrofitkotlinexample.view.fragments.SearchFrag
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), MainListener {

    var bottomNavigationView: BottomNavigationView? = null
    var allCountriesFrag: AllCountriesFrag? = null
    var countriesDetails: CountriesDetailsFrag? = null
    var searchFrag: SearchFrag? = null
    var toolbar: Toolbar? = null

    // bottom navigation item selection
    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        addFragment(allCountriesFrag!!, searchFrag!!)
                        toolbar!!.visibility = View.VISIBLE
                        return true
                    }
                    R.id.find -> {
                        addFragment(searchFrag!!, allCountriesFrag!!)
                        toolbar!!.visibility = View.INVISIBLE
                        return true
                    }
                }
                return false
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareAllView()
// add kountry list fragment as default fragment
        addFragment(allCountriesFrag!!, searchFrag!!)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        //inflater.inflate(R.menu.menu_main, menu)
       // prepareSearchView(menu)
        return true
    }

    fun prepareAllView() {
        prepareToolBar()
        prepareBottomNavView()
        allCountriesFrag =
            AllCountriesFrag()
        searchFrag = SearchFrag()
        countriesDetails = CountriesDetailsFrag()
    }

    fun prepareToolBar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    fun prepareBottomNavView() {
        bottomNavigationView = findViewById(R.id.navigation_bottom)
        bottomNavigationView!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun addFragment1(fragment: Fragment, fragment2: Fragment) {

            supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                    .hide(fragment2)
                    .add(R.id.content, fragment, fragment.javaClass.simpleName)
                    .show(fragment)
                    .addToBackStack(null)
                    .commit()

    }


    private fun addFragment(fragment: Fragment, fragment2: Fragment) {
        if (fragment.isAdded) {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .hide(fragment2)
                .show(fragment)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .hide(fragment2)
                .add(R.id.content, fragment, fragment.javaClass.simpleName)
                .show(fragment)
                .commit()
        }

    }

    override fun gotoDetailsFragment(alpha2Code: String) {
        val args = Bundle()
        args.putString("alpha", alpha2Code)
        countriesDetails?.setArguments(args)
        addFragment1(countriesDetails!!, allCountriesFrag!!)

        toast(alpha2Code)
        /*   val fragment: Fragment = CountriesDetailsFrag()
           val fragment2: Fragment = AllCountriesFrag()
           //activity.supportFragmentManager.beginTransaction().replace(R.id.coun, myFragment).addToBackStack(null).commit()
           supportFragmentManager
                   .beginTransaction()
                   .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                   .hide(fragment2)
                   .add(R.id.content, fragment, fragment.javaClass.simpleName)
                   .show(fragment)
                   .commit()*/
    }


}

