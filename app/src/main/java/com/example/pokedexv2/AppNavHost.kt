package com.example.pokedexv2

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.core.navigation.NavKeys
import com.example.core.navigation.NavigationController
import com.example.feature.authChoice.AuthChoiceScreen
import com.example.feature.initialSplash.InitialSplashScreen
import com.example.feature.login.LoginScreen
import com.example.feature.register.RegisterScreen
import com.example.feature.welcomeView.WelcomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavHost(navigation: NavigationController) {
    NavDisplay(
        backStack = navigation.backStack,
        onBack = { navigation.pop() },
        entryProvider = { key ->
            when (key) {
                NavKeys.InitialSplashScreen -> NavEntry(key) {
                    InitialSplashScreen(
                        initialSplashViewModel = koinViewModel(),
                        navigation = navigation
                    )
                }
                NavKeys.WelcomeScreen -> NavEntry(key) {
                    WelcomeScreen(navigation = navigation)
                }

                NavKeys.AuthScreen -> NavEntry(key) {
                    AuthChoiceScreen(navigation = navigation)
                }

                NavKeys.RegisterScreen -> NavEntry(key) {
                    RegisterScreen(navigation = navigation)
                }

                NavKeys.LoginScreen -> NavEntry(key) {
                    LoginScreen(navigation = navigation)
                }
            }
        }
    )
}