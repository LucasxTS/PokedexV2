package com.example.core.fireBase

import com.google.firebase.auth.FirebaseUser

interface FireBaseAuthProvider {
    suspend fun signIn(): Result<FirebaseUser>
    suspend fun signOut()
}