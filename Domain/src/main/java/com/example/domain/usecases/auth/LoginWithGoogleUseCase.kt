package com.example.domain.usecases.auth

import com.example.domain.models.LoginResult
import com.example.domain.models.User
import com.example.domain.repositories.firebase.FireBaseAuthProviderRepository
import com.example.domain.usecases.datastore.user.GetUserUseCase
import com.example.domain.usecases.datastore.user.SaveUserUseCase

class LoginWithGoogleUseCase(
    private val fireBaseAuthProvider: FireBaseAuthProviderRepository,
    private val saveUserUseCase: SaveUserUseCase,
    private val getUserUseCase: GetUserUseCase
) {
    suspend operator fun invoke(): Result<LoginResult> = runCatching {
        val firebaseUser = fireBaseAuthProvider.signIn().getOrThrow()

        val existUser = getUserUseCase(firebaseUser.uid)

        if (existUser == null) {
            saveUserUseCase(
                User(
                    uuid = firebaseUser.uid,
                    name = firebaseUser.displayName,
                    email = firebaseUser.email,
                    favoritePokemonList = emptyList(),
                    password = null
                ))
            LoginResult.NewAccount
        } else {
            LoginResult.OldAccount
        }
    }
}