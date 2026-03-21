package com.example.feature.createAccount

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateAccountViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<CreateAccountViewState>(CreateAccountViewState.Email)
    val uiState: StateFlow<CreateAccountViewState> = _uiState.asStateFlow()

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var name by mutableStateOf("")

    fun onEmailChange(inputEmail: String) { email = inputEmail }
    fun onPasswordChange(inputPassword: String) { password = inputPassword }
    fun onNameChange(inputName: String) { name = inputName }

    fun nextStep() {
        _uiState.update {
            when (it) {
                CreateAccountViewState.Email -> CreateAccountViewState.Password
                CreateAccountViewState.Password -> CreateAccountViewState.Name
                CreateAccountViewState.Name -> CreateAccountViewState.Name // to do
            }
        }
    }

    fun clearStates() {
        _uiState.update { CreateAccountViewState.Email }
        email = ""
        password = ""
        name = ""
    }

    fun previousStep() {
        _uiState.update {
            when(it) {
                CreateAccountViewState.Email -> null
                CreateAccountViewState.Name -> CreateAccountViewState.Password
                CreateAccountViewState.Password -> CreateAccountViewState.Email
            } ?: return@update it
        }
    }
}