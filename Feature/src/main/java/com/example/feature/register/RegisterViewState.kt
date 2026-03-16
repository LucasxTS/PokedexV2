package com.example.feature.register

sealed class RegisterViewState {
    object Idle : RegisterViewState()
    object Loading : RegisterViewState()
    data class Error(val message: String?) : RegisterViewState()

    sealed class Navigate : RegisterViewState() {
        object ToHome : Navigate()
        object ToWelcome : Navigate()
    }
}

