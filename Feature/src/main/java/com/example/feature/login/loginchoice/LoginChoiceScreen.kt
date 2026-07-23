package com.example.feature.login.loginchoice

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.navigation.NavKeys
import com.example.core.navigation.Navigation
import com.example.designsystems.R
import com.example.designsystems.components.BaseIllustratedImage
import com.example.designsystems.components.GoogleSignInButton
import com.example.designsystems.components.LoadingScreen
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.components.SimpleTopBar
import com.example.designsystems.white
import com.example.feature.base.viewstates.AuthViewState

@Composable
fun LoginChoiceScreen(navigation: Navigation, loginScreenViewModel: LoginChoiceScreenViewModel) {

    val viewState by loginScreenViewModel.uiState.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = viewState,
        transitionSpec = {
            fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
        },
    ) { state ->
        when (state) {
            is AuthViewState.Error -> Unit
            is AuthViewState.Idle -> LoginChoiceScreenContent(
                onGoogleSignIn = { loginScreenViewModel.continueWithGoogle() },
                onLogin = { navigation.navigateTo(NavKeys.LoginScreen) },
                onBack = { navigation.pop() }
            )

            is AuthViewState.Loading -> LoadingScreen()
            is AuthViewState.Navigate -> Unit
        }

        LaunchedEffect(viewState) {
            when (viewState) {
                is AuthViewState.Navigate.ToWelcomeNewUser -> {
                    navigation.clearBackStack(NavKeys.WelcomeNewUser)
                }

                is AuthViewState.Navigate.ToWelcomeBack -> {
                    navigation.clearBackStack(NavKeys.WelcomeBack)
                }

                else -> Unit
            }
        }
    }
}

@Composable
private fun LoginChoiceScreenContent(
    onGoogleSignIn: () -> Unit,
    onLogin: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        SimpleTopBar(
            modifier = Modifier.padding(16.dp),
            title = R.string.register_header_title,
            onBackClick = onBack
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            BaseIllustratedImage(
                image = R.drawable.login_image,
                title = R.string.login_title_label,
                subtitle = R.string.login_subtitle_label
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            GoogleSignInButton(onClick = onGoogleSignIn)
            PrimaryButton(
                text = R.string.register_button_title,
                onClick = onLogin
            )
        }
    }
}

@Preview
@Composable
private fun LoginChoiceChoiceScreenPreview() {
    LoginChoiceScreenContent(
        onGoogleSignIn = {},
        onLogin = {},
        onBack = {}
    )
}