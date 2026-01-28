package com.example.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.edit

class AppDataStore(
    context: Context
) {
    private val dataStore = context.dataStore

    suspend fun checkAndMarkFirstAccess(): Boolean {
        var hasAccess = false

        dataStore.edit { preferences ->
            val currentValue = preferences[FIRST_ACCESS_KEY] ?: false
            hasAccess = currentValue

            if (!currentValue) {
                preferences[FIRST_ACCESS_KEY] = true
            }
        }

        return hasAccess
    }
}