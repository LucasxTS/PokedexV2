package com.example.feature.initialSplash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.example.core.navigation.NavKeys
import com.example.core.navigation.Navigation
import com.example.designsystems.R
import com.example.designsystems.backgroundSplashColor
import com.example.feature.initialSplash.components.rememberPulseScale

@Composable
 fun InitialSplashScreen(
    initialSplashViewModel: InitialSplashViewModel,
    navigation: Navigation
 ) {
     val state by initialSplashViewModel.userAccess.collectAsState()

    LaunchedEffect(state) {
        when (state) {
            InitialSplashUiState.GoToAuthChoice -> { navigation.navigateTo(NavKeys.AuthScreen) }
            InitialSplashUiState.GoToWelcome -> navigation.navigateTo(NavKeys.WelcomeScreen)
            InitialSplashUiState.Idle -> {}
        }
    }
    
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