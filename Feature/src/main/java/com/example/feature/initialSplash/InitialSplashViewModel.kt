package com.example.feature.initialSplash

import androidx.lifecycle.ViewModel
import com.example.core.navigation.NavKeys
import com.example.core.navigation.Navigation
import com.example.domain.dataStore.GetUserFirstAccessUseCase


class InitialSplashViewModel(
    val navigation: Navigation,
    val dataStoreUseCase: GetUserFirstAccessUseCase
) : ViewModel() {

    suspend fun getUserFirstAccess() {
        if (!dataStoreUseCase.hasAlreadyAccessed()) {
            navigation.navigateTo(NavKeys.WelcomeScreen)
            dataStoreUseCase.setFirstAccess()
            return
        }
    }
}