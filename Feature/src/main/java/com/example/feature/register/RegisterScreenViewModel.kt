package com.example.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.LoginResult
import com.example.domain.usecases.auth.LoginWithGoogleUseCase
import kotlinx.coroutines.launch

class RegisterScreenViewModel(
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
) : ViewModel() {

    fun continueWithGoogle() {
        viewModelScope.launch {
            loginWithGoogleUseCase()
                .onSuccess { result ->
                    when(result){
                        is LoginResult.NewAccount -> { }
                        is LoginResult.OldAccount -> { }
                    }
                }
                .onFailure {
                    println(it.message)
                }
        }
    }
}