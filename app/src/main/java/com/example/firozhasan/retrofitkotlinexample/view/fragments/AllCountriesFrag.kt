package com.example.firozhasan.retrofitkotlinexample.view.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountiresAdapter
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountriesViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountriesViewModelFactory


import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


/**
 * A simple [Fragment] subclass.
 */
class AllCountriesFrag : Fragment(), KodeinAware {
    override val kodein by kodein()
    private val factory: AllCountriesViewModelFactory by instance()

    private lateinit var viewModel: AllCountriesViewModel

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CountiresAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(AllCountriesViewModel::class.java)
        //bindUI()
       // Log.d("hellohello","sfsd ");

        Coroutines.main {
            Log.d("hellohello","sfsd ")
            val country = viewModel.allcountries.await()
             country.observe(this, Observer {
                 Log.d("hellohello","sfsd ${it}")

            })
        }
    }

    private fun bindUI() = Coroutines.main {
        //progress_bar.show()
        //Log.d("value", viewModel.allcountries.await()[0].name)


     /*   viewModel.allcountries.await().observe(this, Observer {
            progress_bar.hide()
            initRecyclerView(it.toQuoteItem())
        })*/
    }

   /* private fun initRecyclerView(quoteItem: List<QuoteItem>) {

     *//*   val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(quoteItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }*//*

   *//*     recyclerView = view?.findViewById(R.id.countries_RV)!!
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val mainViewModel = ViewModelProviders.of(this)
                .get(AllCountriesViewModel::class.java)
        //mainViewModel.onChangeFindCountryClick()
        mainViewModel.allCountires.observe(this, Observer<List<Country>> { t ->
            adapter = CountiresAdapter(activity!!, t)
            recyclerView.adapter = adapter*//*


    }
*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.all_countries_frag, container, false)

      /*  recyclerView = view?.findViewById(R.id.countries_RV)!!
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val mainViewModel = ViewModelProviders.of(this)
            .get(AllCountriesViewModel::class.java)
        mainViewModel.onChangeFindCountryClick()
        mainViewModel.allCountires.observe(this, Observer<List<Country>> { t ->
            adapter = CountiresAdapter(activity!!, t)
            recyclerView.adapter = adapter
        }
        )*/
        
        
        
      //  return view
    }


}
