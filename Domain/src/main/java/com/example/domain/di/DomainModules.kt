package com.example.domain.di

import com.example.domain.dataStore.GetUserFirstAccessUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserFirstAccessUseCase(get()) }
}
