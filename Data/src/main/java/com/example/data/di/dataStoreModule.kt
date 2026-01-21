package com.example.data.di

import com.example.data.dataStore.AppDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { AppDataStore(context = androidContext()) }
}