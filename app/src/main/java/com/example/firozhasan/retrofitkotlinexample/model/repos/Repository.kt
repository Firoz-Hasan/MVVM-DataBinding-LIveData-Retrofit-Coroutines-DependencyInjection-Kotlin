package com.example.firozhasan.retrofitkotlinexample.model.repos

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.firozhasan.retrofitkotlinexample.model.api.*
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository : SafeApiRequest()
// object is same as static in java
{

    private var apiclient: JobServices? = null
    private var loginapiclient: JobServices? = null

    /*this variable are for getting country name by giving capital name*/
    private val _currentCountryName = MutableLiveData<String>()
    val currentCountryName: LiveData<String>
        get() = _currentCountryName

    /*this variable provides list of countries*/
    val _countires: MutableLiveData<List<Country>> = MutableLiveData()
    val getAllCountires: LiveData<List<Country>>
        get() = _countires

    /*this variable provides list of countries*/
    val _authentication = MutableLiveData<String>()
    val getAuthentication: LiveData<String>
        get() = _authentication


    init {
        _currentCountryName.value = "N/A"
        apiclient = CountryAPI.client.create(JobServices::class.java)
        //loginapiclient = LoginAPI.client.create(JobServices::class.java)
    }

    fun getCountyNameByCapital(capital: String
    ) {
        val call = apiclient?.getKountry(capital)

        call?.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                Log.d("failure", t.toString())
            }

            override fun onResponse(call: Call<List<Country>>?, response: Response<List<Country>>?) {
                if (response?.isSuccessful!!) {
                    var results = response?.body()?.get(0)?.name
                    Log.d("success", results)
                    //    countryTV?.setText(results)
                    _currentCountryName.value = results.toString()


                }


            }


        })
    }


    fun getALLCounty() {
        val call = apiclient?.getAllCountries()

        call?.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                Log.d("failure", t.toString())
            }

            override fun onResponse(call: Call<List<Country>>?, response: Response<List<Country>>?) {
                if (response?.isSuccessful!!) {
                    var results = response?.body()?.size
                    Log.d("success", results.toString())
                    _countires.value = response.body()

                }
            }
        })
    }

    suspend fun userLogin(email: String, password: String): User {
        /*   val call = loginapiclient?.userLogin(email, password)

           call?.enqueue(object : Callback<User> {
               override fun onFailure(call: Call<User>, t: Throwable) {
                   Log.d("failure", t.toString())
                   _authentication.value = t.message

               }

               override fun onResponse(call: Call<User>?, response: Response<User>?) {
                   if (response?.isSuccessful!!) {
                       var results = response?.body()
                       Log.d("success", results.toString())
                       _authentication.value = response.body()?.toString()

                   }
                   else {
                       _authentication.value = response.errorBody()?.toString()

                   }
               }
           })
       return _authentication*/

        return apiRequest { LoginAPI().userLogin(email, password) }

    }
}