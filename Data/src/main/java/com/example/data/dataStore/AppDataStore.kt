package com.example.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AppDataStore(
    context: Context
) {
    private val dataStore = context.dataStore

    suspend fun hasAlreadyAccessed(): Boolean {
        return dataStore.data.map { preferences ->
            preferences[FIRST_ACCESS_KEY] ?: false
        }
            .first()
    }

    suspend fun setFirstAccess() {
        dataStore.edit { preferences ->
            preferences[FIRST_ACCESS_KEY] = true
        }
    }
}