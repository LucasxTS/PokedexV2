package com.example.feature.base.viewstates

sealed class AuthViewState {
    object Idle : AuthViewState()
    object Loading : AuthViewState()
    data class Error(val message: String?) : AuthViewState()

    sealed class Navigate : AuthViewState() {
        object ToHome : Navigate()
        object ToWelcome : Navigate()
    }
}