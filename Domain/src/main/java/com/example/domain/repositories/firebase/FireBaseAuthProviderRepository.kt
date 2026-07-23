package com.example.domain.repositories.firebase

import com.google.firebase.auth.FirebaseUser

interface FireBaseAuthProviderRepository {
    suspend fun signInWithGoogle(): Result<FirebaseUser>
    suspend fun signInWithPassword(email: String, password: String): Result<FirebaseUser>
    suspend fun signOut()
}