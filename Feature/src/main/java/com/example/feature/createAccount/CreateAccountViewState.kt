package com.example.feature.createAccount

sealed class CreateAccountViewState {
    object Email: CreateAccountViewState()
    object Password: CreateAccountViewState()
    object Name: CreateAccountViewState()
}