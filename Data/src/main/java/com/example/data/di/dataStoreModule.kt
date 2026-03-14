package com.example.data.di

import com.example.data.dataStore.AppDataStore
import com.example.data.dataStore.implementations.firstaccess.DataStoreFirstAccessRepositoryImpl
import com.example.data.dataStore.implementations.saveuser.UserRepositoryImpl
import com.example.domain.repositories.datastore.firstaccess.DataStoreFirstAccessRepository
import com.example.domain.repositories.datastore.user.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { AppDataStore(context = androidContext()) }
    
    factory<DataStoreFirstAccessRepository> { DataStoreFirstAccessRepositoryImpl(dataStore = get()) }
    factory<UserRepository> { UserRepositoryImpl(dataStore = get()) }
}
