package com.example.feature.initialSplash

sealed interface InitialSplashUiState {
    data object Idle : InitialSplashUiState
    data object GoToLogin : InitialSplashUiState
    data object GoToWelcome : InitialSplashUiState
}