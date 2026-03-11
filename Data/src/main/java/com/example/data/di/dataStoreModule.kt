package com.example.data.di

import com.example.data.dataStore.AppDataStore
import com.example.data.dataStore.DataStoreFirstAccessRepositoryImpl
import com.example.domain.dataStore.repository.DataStoreFirstAccessRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { AppDataStore(context = androidContext()) }
    
    factory<DataStoreFirstAccessRepository> { DataStoreFirstAccessRepositoryImpl(dataStore = get()) }
}
