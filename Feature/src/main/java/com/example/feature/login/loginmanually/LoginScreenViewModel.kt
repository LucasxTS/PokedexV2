package com.example.feature.login.loginmanually

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repositories.firebase.FireBaseAuthProviderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModel(private val fireBaseAuthProviderRepository: FireBaseAuthProviderRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginViewState>(LoginViewState.Idle)
    val uiState: StateFlow<LoginViewState> = _uiState

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun onEmailChange(inputEmail: String) {
        email = inputEmail
    }

    fun onPasswordChange(inputPassword: String) {
        password = inputPassword
    }

    fun loginWithPassword() {
        if (email.isEmpty() || password.isEmpty()) {
            return
        }

        if (!isValidEmail(email)) {
            _uiState.update { LoginViewState.Error("Invalid email format") }
            return
        }

        _uiState.update { LoginViewState.Loading }
        viewModelScope.launch {
            fireBaseAuthProviderRepository.signInWithPassword(email, password).onSuccess {
                _uiState.update { LoginViewState.Success }
                println("Login successful")
            }.onFailure {
                _uiState.update { LoginViewState.Error(it.toString()) }
                println(it.toString())
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
