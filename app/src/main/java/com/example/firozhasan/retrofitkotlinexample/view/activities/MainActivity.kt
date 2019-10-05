package com.example.firozhasan.retrofitkotlinexample.view.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.view.fragments.All_Countries_Frag
import com.example.firozhasan.retrofitkotlinexample.view.fragments.Search_frag
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var bottomNavigationView: BottomNavigationView? = null
    var allCountriesFrag: All_Countries_Frag? = null
    var searchFrag: Search_frag? = null
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
            All_Countries_Frag()
        searchFrag = Search_frag()
    }

    fun prepareToolBar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    fun prepareBottomNavView() {
        bottomNavigationView = findViewById(R.id.navigation_bottom)
        bottomNavigationView!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
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


}

