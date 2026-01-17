package com.example.feature.welcomeView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.backgroundSplashColor
import com.example.designsystems.white

@Composable
fun WelcomeScreen() {
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(backgroundSplashColor)
                .fillMaxSize()
        ) {
            Text("TestExample", color = white)
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}