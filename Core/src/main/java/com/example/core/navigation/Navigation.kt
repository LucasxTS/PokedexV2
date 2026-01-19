package com.example.core.navigation

interface Navigation {
    fun navigateTo(navKey: NavKeys)
    fun pop()
    fun clearBackStack(navKey: NavKeys)
}