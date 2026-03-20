package com.example.feature.welcomeViews

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WelcomePage(
    @param:DrawableRes val image: Int,
    @param:StringRes val title: Int,
    @param:StringRes val subtitle: Int
)
