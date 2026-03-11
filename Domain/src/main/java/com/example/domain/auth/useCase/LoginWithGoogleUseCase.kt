package com.example.domain.auth.useCase

import com.example.core.fireBase.FireBaseAuthProvider
import com.google.firebase.auth.FirebaseUser

class LoginWithGoogleUseCase(
    private val fireBaseAuthProvider: FireBaseAuthProvider
) {
    suspend operator fun invoke(): Result<FirebaseUser> {
        return fireBaseAuthProvider.signIn()
    }
}