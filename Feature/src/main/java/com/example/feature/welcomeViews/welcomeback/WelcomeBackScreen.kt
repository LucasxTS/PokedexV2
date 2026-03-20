package com.example.feature.welcomeViews.welcomeback

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationController
import com.example.designsystems.R
import com.example.designsystems.components.BaseIllustratedImage
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.white

@Composable
fun WelcomeBackScreen(navigation: Navigation) {
    WelcomeBackScreenContent({})
}

@Composable
fun WelcomeBackScreenContent(navigateToHome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            BaseIllustratedImage(
                image = R.drawable.welcome_back_trainer,
                title = R.string.welcome_back_title,
                subtitle = R.string.welcome_back_subtitle
            )
        }

        PrimaryButton(
            text = R.string.welcome_back_text_button,
            onClick = navigateToHome
        )
    }
}

@Preview
@Composable
private fun WelcomeBackScreenPreview() {
    WelcomeBackScreen(NavigationController())
}