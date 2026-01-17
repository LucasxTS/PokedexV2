package com.example.feature.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.R
import com.example.designsystems.backgroundSplashColor

@Composable
 fun WelcomeSplashScreen() {
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(backgroundSplashColor)
                .fillMaxSize()
        ) {
           Image(
               painter = painterResource(R.drawable.pok_dexicon),
               contentDescription = null,
               modifier = Modifier.scale(rememberPulseScale())
           )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    WelcomeSplashScreen()
}