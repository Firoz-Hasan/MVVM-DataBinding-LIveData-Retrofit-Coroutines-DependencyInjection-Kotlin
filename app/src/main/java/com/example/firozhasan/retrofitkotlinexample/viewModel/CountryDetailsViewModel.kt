package com.example.firozhasan.retrofitkotlinexample.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firozhasan.retrofitkotlinexample.model.repos.CountryDetailsRepository
import com.example.firozhasan.retrofitkotlinexample.util.Status
import com.google.android.gms.maps.model.LatLng


class CountryDetailsViewModel(private val repository : CountryDetailsRepository) : ViewModel() {
    var alpha2Code: String? = null
    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status>
        get() = _status
    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String>
        get() = _capital
    private val _country = MutableLiveData<String>()
    val country: LiveData<String>
        get() = _country
    private val _area = MutableLiveData<String>()
    val area: LiveData<String>
        get() = _area
    private val _population = MutableLiveData<String>()
    val population: LiveData<String>
        get() = _population

    private val _region = MutableLiveData<String>()
    val region: LiveData<String>
        get() = _region
    private val _timezone = MutableLiveData<String>()
    val timezone: LiveData<String>
        get() = _timezone

    private val _currency = MutableLiveData<String>()
    val currency: LiveData<String>
        get() = _currency
    private val _language = MutableLiveData<String>()
    val language: LiveData<String>
        get() = _language
    private val _flag = MutableLiveData<String>()
    val flag: LiveData<String>
        get() = _flag
    val lat: MutableLiveData<Double>
        get() = repository.detailsLat
    val lng: MutableLiveData<Double>
        get() = repository.detailsLng

   // val mMapLatLng: MutableLiveData<LatLng> get() = repository.detailsLatLng

    private val _mMapLatLng = MutableLiveData<LatLng>()
    val mMapLatLng: LiveData<LatLng>
        get() = _mMapLatLng

    //ObservableField<LatLng?>()
    suspend fun alpha2CountryDetails(alpha : String) {

            Log.d("hellohello", "alpha2CountryDetails = ${alpha} ")
            repository.getCountryDetails(alpha)
        _capital.value = repository.detailsCapital?.value
        _country.value = repository.detailsCountry?.value
        _area.value = repository.detailsArea?.value
        _population.value = repository.detailsPopulation?.value
        _region.value = repository.detailsRegion?.value
        _timezone.value = repository.detailsTimezone?.value
        _currency.value = repository.detailsCurrency?.value
        _language.value = repository.detailsLanguage?.value
        _flag.value = repository.detailsFlag?.value
        _mMapLatLng.value = repository.detailsLatLng?.value
    }
}