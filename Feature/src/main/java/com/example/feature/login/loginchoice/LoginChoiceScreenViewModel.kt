package com.example.feature.login.loginchoice

import com.example.domain.usecases.auth.LoginWithGoogleUseCase
import com.example.feature.base.BaseAuthViewModel
import com.example.feature.base.viewstates.AuthViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginChoiceScreenViewModel(loginWithGoogleUseCase: LoginWithGoogleUseCase) : BaseAuthViewModel(loginWithGoogleUseCase) {

    private val _uiState = MutableStateFlow<AuthViewState>(AuthViewState.Idle)
    val uiState: StateFlow<AuthViewState> = _uiState.asStateFlow()

    override fun onLoading() {
        _uiState.update { AuthViewState.Loading }
    }

    override fun onNewAccount() {
        _uiState.update { AuthViewState.Navigate.ToWelcomeNewUser }
    }

    override fun onExistingAccount() {
        _uiState.update { AuthViewState.Navigate.ToWelcomeBack }
    }

    override fun onError(message: String?) {
        println(message)
    }

    override fun onCloseCredentialRequest() {
        TODO("Not yet implemented")
    }
}