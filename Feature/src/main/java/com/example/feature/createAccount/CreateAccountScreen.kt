package com.example.feature.createAccount

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.navigation.Navigation
import com.example.designsystems.R
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.components.SimpleTopBar
import com.example.designsystems.white
import com.example.feature.createAccount.components.EmailStep
import com.example.feature.createAccount.components.NameStep
import com.example.feature.createAccount.components.PasswordStep

@Composable
fun CreateAccountScreen(navigation: Navigation, viewModel: CreateAccountViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BackHandler(enabled = uiState != CreateAccountViewState.Email) {
        viewModel.previousStep()
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(white)
    ) {
        CreateAccountContent(
            currentStep = uiState,
            email = viewModel.email,
            password = viewModel.password,
            name = viewModel.name,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onNameChange = viewModel::onNameChange,
            onContinue = viewModel::nextStep,
            onBack = {
                navigation.pop()
                viewModel.clear()
            }
        )
    }
}

@Composable
private fun CreateAccountContent(
    currentStep: CreateAccountViewState,
    email: String,
    password: String,
    name: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onContinue: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        SimpleTopBar(
            title = R.string.create_account_title_label,
            onBackClick = onBack
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            AnimatedContent(
                targetState = currentStep,
            ) { step ->
                when (step) {
                    CreateAccountViewState.Email -> EmailStep(
                        value = email,
                        onValueChange = onEmailChange
                    )

                    CreateAccountViewState.Password -> PasswordStep(
                        value = password,
                        onValueChange = onPasswordChange
                    )

                    CreateAccountViewState.Name -> NameStep(
                        value = name,
                        onValueChange = onNameChange
                    )
                }
            }
        }

        PrimaryButton(
            modifier = Modifier.padding(16.dp),
            text = when (currentStep) {
                CreateAccountViewState.Name -> R.string.name_button_label
                else -> R.string.email_button_label
            },
            onClick = onContinue
        )
    }
}

@Preview
@Composable
private fun CreateAccountContentPreview() {
    CreateAccountContent(
        currentStep = CreateAccountViewState.Email,
        email = "",
        password = "",
        name = "",
        onEmailChange = {},
        onPasswordChange = {},
        onNameChange = {},
        onContinue = {},
        onBack = {},
    )
}