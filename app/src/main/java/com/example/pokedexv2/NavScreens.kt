package com.example.pokedexv2

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavScreens: NavKey {

    @Serializable
    data object InitialSplashScreen : NavScreens

    @Serializable
    data object WelcomeScreen : NavScreens
}