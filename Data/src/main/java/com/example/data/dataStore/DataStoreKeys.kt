package com.example.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(
    name = "app_settings"
)

val FIRST_ACCESS_KEY = booleanPreferencesKey("first_user_access")