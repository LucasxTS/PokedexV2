package com.example.di


import com.example.feature.initialSplash.InitialSplashViewModel
import com.example.feature.register.RegisterScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModel = module {

    viewModelOf(::InitialSplashViewModel)
    viewModelOf(::RegisterScreenViewModel)
}