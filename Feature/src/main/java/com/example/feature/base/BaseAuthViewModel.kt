package com.example.feature.base

import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.LoginResult
import com.example.domain.usecases.auth.LoginWithGoogleUseCase
import kotlinx.coroutines.launch

abstract class BaseAuthViewModel(
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase
) : ViewModel() {

    protected abstract fun onLoading()
    protected abstract fun onNewAccount()
    protected abstract fun onExistingAccount()
    protected abstract fun onError(message: String?)
    protected abstract fun onCloseCredentialRequest()

    fun continueWithGoogle() {
        onLoading()
        viewModelScope.launch {
            loginWithGoogleUseCase()
                .onSuccess { result ->
                    when (result) {
                        is LoginResult.NewAccount -> onNewAccount()
                        is LoginResult.OldAccount -> onExistingAccount()
                    }
                }
                .onFailure { error ->
                    when(error) {
                        is GetCredentialCancellationException -> onCloseCredentialRequest()
                        else -> onError(error.message)
                    }
                }
        }
    }
}