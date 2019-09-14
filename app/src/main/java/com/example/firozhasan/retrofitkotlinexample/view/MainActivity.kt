package com.example.firozhasan.retrofitkotlinexample.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.example.firozhasan.retrofitkotlinexample.R
import kotlinx.android.synthetic.main.activity_main.*

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
                    R.id.search -> {
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
        /*   val mainViewModel = ViewModelProviders.of(this)
                   .get(CountryViewModel::class.java)

           DataBindingUtil.setContentView<ActivityMainBinding>(
                   this, R.layout.activity_main
           ).apply {
               this.setLifecycleOwner(this@MainActivity)
               this.viewmodel = mainViewModel
           }*/


    }

    fun prepareAllView() {
        prepareToolBar()
        prepareBottomNavView()
        allCountriesFrag = All_Countries_Frag()
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
                .add(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .show(fragment)
                .commit()
        }

    }


}

