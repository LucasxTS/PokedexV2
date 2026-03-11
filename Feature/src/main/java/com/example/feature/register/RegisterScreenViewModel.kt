package com.example.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.auth.useCase.LoginWithGoogleUseCase
import kotlinx.coroutines.launch

class RegisterScreenViewModel(private val loginWithGoogleUseCase: LoginWithGoogleUseCase) : ViewModel() {

    fun continueWithGoogle() {
        viewModelScope.launch {
            loginWithGoogleUseCase()
                .onSuccess {
                }
                .onFailure {
                }
        }
    }
}