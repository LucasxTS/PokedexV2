package com.example.pokedexv2

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.core.navigation.NavKeys
import com.example.core.navigation.NavigationController
import com.example.feature.authChoice.AuthChoiceScreen
import com.example.feature.createAccount.CreateAccountScreen
import com.example.feature.initialSplash.InitialSplashScreen
import com.example.feature.login.loginchoice.LoginChoiceScreen
import com.example.feature.register.RegisterScreen
import com.example.feature.welcomeViews.WelcomeScreen
import com.example.feature.welcomeViews.welcomeback.WelcomeBackScreen
import com.example.feature.welcomeViews.welcomenewuser.WelcomeNewUser
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
                    RegisterScreen(
                        navigation = navigation,
                        registerScreenViewModel = koinViewModel(),
                    )
                }

                NavKeys.LoginChoiceScreen -> NavEntry(key) {
                    LoginChoiceScreen(
                        navigation = navigation,
                        loginScreenViewModel = koinViewModel()
                    )
                }

                NavKeys.WelcomeBack -> NavEntry(key) {
                    WelcomeBackScreen(navigation = navigation)
                }

                NavKeys.WelcomeNewUser -> NavEntry(key) {
                    WelcomeNewUser(navigation = navigation)
                }

                NavKeys.CreateAccountScreen -> NavEntry(key) {
                    CreateAccountScreen(
                        navigation = navigation,
                        viewModel = koinViewModel()
                    )
                }
            }
        }
    )
}