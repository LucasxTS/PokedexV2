package com.example.feature.login.loginmanually

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.navigation.Navigation
import com.example.designsystems.R
import com.example.designsystems.components.AuthTextField
import com.example.designsystems.components.AuthTitleAndSubTitle
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.components.SimpleTopBar
import com.example.designsystems.white

@Composable
fun LoginScreen(navigation: Navigation, viewModel: LoginScreenViewModel) {

    Column {
        LoginScreenContent(
            onBack = { navigation.pop() },
            emailValue = viewModel.email,
            passwordValue = viewModel.password,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            logInButton = { viewModel.loginWithPassword() }
        )
    }
}

@Composable
fun LoginScreenContent(
    onBack: () -> Unit,
    emailValue: String,
    passwordValue: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    logInButton: () -> Unit
) {
    Column(
        Modifier
            .background(white)
            .fillMaxSize()
    ) {
        SimpleTopBar(
            title = R.string.login_top_bar_title,
            onBackClick = onBack,
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column {
                AuthTitleAndSubTitle(
                    title = R.string.login_welcome_title,
                    subtitle = R.string.login_welcome_subtitle,
                )

                AuthTextField(
                    value = emailValue,
                    isPassword = false,
                    placeholder = R.string.login_placeholder_email,
                    onValueChange = onEmailChange,
                    keyboardType = KeyboardType.Email,
                    isRegister = false
                )

                AuthTextField(
                    value = passwordValue,
                    isPassword = true,
                    placeholder = R.string.login_placeholder_password,
                    onValueChange = onPasswordChange,
                    keyboardType = KeyboardType.Password,
                    isRegister = false
                )
            }
        }

        PrimaryButton(
            modifier = Modifier.padding(16.dp),
            text = R.string.login_button_label,
            onClick = logInButton
        )
    }
}

@Preview
@Composable
private fun LoginScreenContentPreview() {
    LoginScreenContent(
        onBack = {},
        emailValue = "",
        passwordValue = "",
        onEmailChange = {},
        onPasswordChange = {},
        logInButton = {}
    )
}