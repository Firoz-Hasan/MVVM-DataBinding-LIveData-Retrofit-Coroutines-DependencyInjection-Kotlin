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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.databinding.AllCountriesFragBinding
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.util.Coroutines
import com.example.firozhasan.retrofitkotlinexample.util.hide
import com.example.firozhasan.retrofitkotlinexample.util.show
import com.example.firozhasan.retrofitkotlinexample.util.toast
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountiresAdapter
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountriesAdapter2
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountryListener
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountriesViewModel
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountriesViewModelFactory
import kotlinx.android.synthetic.main.all_countries_frag.*


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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = AllCountriesFragBinding.inflate(inflater)

        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this, factory).get(AllCountriesViewModel::class.java)

        binding.allCountiresViewmodel = viewModel

        binding.countriesRV.adapter = CountriesAdapter2(CountryListener { country ->
            Toast.makeText(context, "${country?.name}", Toast.LENGTH_SHORT).show()
            //viewModel.displayUserDetails(it)
        })


        /*     viewModel.navigateToUserDetails.observe(this, Observer {
                 it?.let {
                     findNavController().navigate(UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(it))
                     viewModel.displayUserDetailsComplete()
                 }
             }
             )*/

        /*  binding.btn.setOnClickListener {
              view: View? ->  view?.findNavController()?.navigate(R.id.viewPagerFragment)
          }*/

        return binding.root


    }
}
