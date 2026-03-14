package com.example.domain.repositories.firebase

import com.google.firebase.auth.FirebaseUser

interface FireBaseAuthProviderRepository {
    suspend fun signIn(): Result<FirebaseUser>
    suspend fun signOut()
}