package com.example.pokedexv2.di

import com.example.core.fireBase.FireBaseAuthProvider
import com.example.data.fireBase.FireBaseAuthProviderImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { FirebaseAuth.getInstance() }

    factory<FireBaseAuthProvider>{ FireBaseAuthProviderImpl(
        context = androidContext(),
        fireBaseAuth = get(),
        webClientId = androidContext().getString(com.firebase.ui.auth.R.string.default_web_client_id)
    ) }
}