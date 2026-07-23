package com.example.di


import com.example.feature.createAccount.CreateAccountViewModel
import com.example.feature.initialSplash.InitialSplashViewModel
import com.example.feature.login.loginchoice.LoginChoiceScreenViewModel
import com.example.feature.login.loginmanually.LoginScreenViewModel
import com.example.feature.register.RegisterScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModel = module {

    viewModelOf(::InitialSplashViewModel)
    viewModelOf(::RegisterScreenViewModel)
    viewModelOf(::LoginChoiceScreenViewModel)
    viewModelOf(::CreateAccountViewModel)
    viewModelOf(::LoginScreenViewModel)
}