package com.example.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.LoginResult
import com.example.domain.usecases.auth.LoginWithGoogleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterScreenViewModel(
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<RegisterViewState>(RegisterViewState.Idle)
    val uiState: StateFlow<RegisterViewState> = _uiState.asStateFlow()

    fun continueWithGoogle() {
        _uiState.update { RegisterViewState.Loading }
        viewModelScope.launch {
            loginWithGoogleUseCase()
                .onSuccess { result ->
                    when (result) {
                        is LoginResult.NewAccount -> {
                            _uiState.update { RegisterViewState.Navigate.ToWelcome }
                        }

                        is LoginResult.OldAccount -> {
                            _uiState.update { RegisterViewState.Navigate.ToHome }
                        }
                    }
                }
                .onFailure {
                    println(it.message)
                }
        }
    }
}