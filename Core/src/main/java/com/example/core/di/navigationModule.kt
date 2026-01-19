package com.example.core.di

import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationController
import org.koin.dsl.module

val navigationModule = module {

    single { NavigationController() }
    single<Navigation> { get<NavigationController>() }
}