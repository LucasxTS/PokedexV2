package com.example.domain.di

import com.example.domain.auth.useCase.LoginWithGoogleUseCase
import com.example.domain.dataStore.useCase.GetUserFirstAccessUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserFirstAccessUseCase(repository = get()) }
    factory { LoginWithGoogleUseCase( fireBaseAuthProvider = get()) }
}
