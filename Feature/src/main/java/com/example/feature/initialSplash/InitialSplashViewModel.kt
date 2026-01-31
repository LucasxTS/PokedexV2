package com.example.feature.initialSplash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.domain.dataStore.GetUserFirstAccessUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class InitialSplashViewModel(
    private val getUserFirstAccessUseCase: GetUserFirstAccessUseCase
) : ViewModel() {

    private val _userAccess = MutableStateFlow<InitialSplashUiState>(InitialSplashUiState.Idle)
    val userAccess = _userAccess.asStateFlow()

    init {
        getUserFirstAccess()
    }

       fun getUserFirstAccess() {
         viewModelScope.launch {
             val hasAccess = getUserFirstAccessUseCase()
             _userAccess.value = if (hasAccess) {
                 InitialSplashUiState.GoToAuthChoice
             } else {
                 InitialSplashUiState.GoToWelcome
             }
         }
    }
}