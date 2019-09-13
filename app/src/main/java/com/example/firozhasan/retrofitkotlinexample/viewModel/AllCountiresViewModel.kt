package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.repos.countryRepos
import com.example.firozhasan.retrofitkotlinexample.view.adapters.CountiresAdapter

class AllCountiresViewModel : ViewModel() {
     val allCountires: LiveData<List<Country>>
        get() = countryRepos.countires

    fun onChangeFindCountryClick() = countryRepos.getALLCounty()

  //  private var dogBreeds: DogBreeds? = null
    private var adapter: CountiresAdapter? = null
  //  var selected: MutableLiveData<DogBreed>

    fun init() {
    //    dogBreeds = DogBreeds()
    //    selected = MutableLiveData()
     //   adapter = DogBreedsAdapter(R.layout.view_dog_breed, this)
    }

}