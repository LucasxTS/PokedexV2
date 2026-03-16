package com.example.domain.models


sealed class LoginResult {
    object NewAccount : LoginResult()
    object OldAccount : LoginResult()
}