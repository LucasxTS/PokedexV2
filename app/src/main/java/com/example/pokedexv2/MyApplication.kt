package com.example.pokedexv2

import android.app.Application
import com.example.core.di.navigationModule
import com.example.data.di.dataModule
import com.example.di.viewModel
import com.example.domain.di.domainModule
import com.example.pokedexv2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication(): Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                navigationModule, viewModel, dataModule, domainModule, appModule
            )
        }
    }
}