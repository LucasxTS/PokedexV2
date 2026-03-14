package com.example.domain.models

import com.google.firebase.auth.FirebaseUser

sealed class LoginResult {
    data class NewAccount(val fireBaseUser: FirebaseUser) : LoginResult()
    data class OldAccount(val fireBaseUser: FirebaseUser) : LoginResult()
}