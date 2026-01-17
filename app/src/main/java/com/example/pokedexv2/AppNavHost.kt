package com.example.pokedexv2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.example.feature.initialSplash.InitialSplashScreen
import com.example.feature.welcomeView.WelcomeScreen

@Composable
fun AppNavHost() {
    val backstack = remember { mutableStateListOf<NavKey>(NavScreens.InitialSplashScreen) }

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is NavScreens.InitialSplashScreen -> NavEntry(key) {
                    InitialSplashScreen()
                }
                is NavScreens.WelcomeScreen -> NavEntry(key) {
                    WelcomeScreen()
                }
                else -> throw IllegalStateException("Unknown screen $key")
            }
        }
    )
}