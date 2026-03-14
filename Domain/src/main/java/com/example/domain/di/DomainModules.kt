package com.example.domain.di

import com.example.domain.usecases.auth.LoginWithGoogleUseCase
import com.example.domain.usecases.datastore.firstaccess.GetUserFirstAccessUseCase
import com.example.domain.usecases.datastore.user.GetUserUseCase
import com.example.domain.usecases.datastore.user.SaveUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserFirstAccessUseCase(repository = get()) }
    factory { LoginWithGoogleUseCase(
        fireBaseAuthProvider = get(),
        saveUserUseCase = get(),
        getUserUseCase = get()
    ) }
    factory { GetUserUseCase(repository = get()) }
    factory { SaveUserUseCase(repository = get()) }
}
