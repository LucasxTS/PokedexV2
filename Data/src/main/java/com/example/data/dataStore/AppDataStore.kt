package com.example.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.domain.models.User
import com.google.gson.Gson
import kotlinx.coroutines.flow.first

class AppDataStore(
    context: Context
) {
    private val dataStore = context.dataStore
    private val gson = Gson()

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

    suspend fun saveUser(user: User) {
        dataStore.edit { preferences ->
            preferences[userKey(user.uuid)] = gson.toJson(user)
        }
    }

    suspend fun getUser(uuid: String): User? {
        val preferences = dataStore.data.first()
        val json = preferences[userKey(uuid)] ?: return null
        return gson.fromJson(json, User::class.java)
    }
}