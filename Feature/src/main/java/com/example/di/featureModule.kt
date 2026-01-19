package com.example.di

import com.example.feature.initialSplash.InitialSplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModel = module {

    viewModelOf(::InitialSplashViewModel)
}