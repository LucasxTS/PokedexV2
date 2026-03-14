package com.example.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.auth.LoginWithGoogleUseCase
import kotlinx.coroutines.launch

class LoginScreenViewModel(private val loginWithGoogleUseCase: LoginWithGoogleUseCase) : ViewModel() {

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