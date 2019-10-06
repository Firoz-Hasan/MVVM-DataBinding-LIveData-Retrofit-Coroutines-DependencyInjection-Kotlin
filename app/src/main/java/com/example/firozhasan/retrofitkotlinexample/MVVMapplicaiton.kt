/*
package com.example.firozhasan.retrofitkotlinexample

import android.app.Application
import com.example.firozhasan.retrofitkotlinexample.model.api.LoginAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.NetworkConnectionInterceptor
import com.example.firozhasan.retrofitkotlinexample.model.repos.LoginRepository
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMapplicaiton : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMapplicaiton))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { LoginAPI(instance()) }
        bind() from singleton { LoginRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance())}
    }
}*/
