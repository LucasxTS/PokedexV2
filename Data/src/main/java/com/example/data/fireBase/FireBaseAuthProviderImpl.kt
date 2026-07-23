package com.example.data.fireBase

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.example.domain.repositories.firebase.FireBaseAuthProviderRepository
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await

class FireBaseAuthProviderImpl(
    private val context: Context,
    private val fireBaseAuth: FirebaseAuth,
    private val webClientId: String
): FireBaseAuthProviderRepository {

    override suspend fun signInWithGoogle(): Result<FirebaseUser> = runCatching {
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(webClientId)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        val credentialManager = CredentialManager.create(context)
        val result = credentialManager.getCredential(context, request)
        val credential = result.credential

        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
        val idToken = googleIdTokenCredential.idToken

        val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
        val authResult = fireBaseAuth.signInWithCredential(firebaseCredential).await()

        authResult.user ?: throw Exception("Usuário nulo após login")
    }

    override suspend fun signInWithPassword(
        email: String,
        password: String
    ): Result<FirebaseUser> = runCatching {
        val result = fireBaseAuth
            .signInWithEmailAndPassword(email, password)
            .await()

        result.user ?: throw Exception("User not found")
    }


    override suspend fun signOut() {
        fireBaseAuth.signOut()
    }
}