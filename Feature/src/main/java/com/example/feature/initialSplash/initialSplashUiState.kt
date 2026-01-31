package com.example.feature.initialSplash

sealed interface InitialSplashUiState {
    data object Idle : InitialSplashUiState
    data object GoToAuthChoice : InitialSplashUiState
    data object GoToWelcome : InitialSplashUiState
}