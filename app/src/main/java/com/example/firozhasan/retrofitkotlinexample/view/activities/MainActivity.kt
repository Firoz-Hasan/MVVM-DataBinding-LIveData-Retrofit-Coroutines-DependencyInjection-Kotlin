package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.view.fragments.AllCountriesFrag
import com.example.firozhasan.retrofitkotlinexample.view.fragments.CountriesDetailsFrag
import com.example.firozhasan.retrofitkotlinexample.view.fragments.SearchFrag
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

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
                        addFragment(allCountriesFrag!!, searchFrag!!, countriesDetails!!)
                        toolbar!!.visibility = View.VISIBLE
                        return true
                    }
                    R.id.find -> {
                        addFragment(searchFrag!!, allCountriesFrag!!, countriesDetails!!)
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
        addFragment(allCountriesFrag!!, searchFrag!! , countriesDetails!!)



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
    private fun addFragment(fragment: Fragment, fragment2: Fragment, fragment3: Fragment) {
        if (fragment.isAdded) {
            Log.d("which", "1")
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .hide(fragment2)
                    .hide(fragment3)
                .show(fragment)

                .commit()
        } else {
            Log.d("which", "2")
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .hide(fragment2)
                    .hide(fragment3)
                .add(R.id.content, fragment, fragment.javaClass.simpleName)
                .show(fragment)


                .commit()
        }

    }

/*    override fun gotoDetailsFragment(alpha2Code: String) {
        val args = Bundle()
        args.putString("alpha", alpha2Code)
        countriesDetails?.setArguments(args)
        addFragment(countriesDetails!!, allCountriesFrag!!, searchFrag!!)
        toast(alpha2Code)
    }

    override fun gotoDetailsActivity(alpha2Code: String) {
        val intent = Intent(this, CountryDetails::class.java)
        intent.putExtra("alpha", alpha2Code)
        startActivity(intent)
    }*/


}

