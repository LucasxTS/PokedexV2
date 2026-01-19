package com.example.core.navigation

import androidx.compose.runtime.mutableStateListOf

class NavigationController: Navigation {
    val backStack = mutableStateListOf<NavKeys>(NavKeys.InitialSplashScreen)

    override fun navigateTo(navKey: NavKeys) {
        backStack.add(navKey)
    }

    override fun pop() {
        backStack.removeLastOrNull()
    }

    override fun clearBackStack(navKey: NavKeys) {
        backStack.clear()
        backStack.add(navKey)
    }

}