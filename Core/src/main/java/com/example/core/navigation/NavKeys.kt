package com.example.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavKeys: NavKey {

    @Serializable
    data object InitialSplashScreen : NavKeys

    @Serializable
    data object WelcomeScreen : NavKeys
}