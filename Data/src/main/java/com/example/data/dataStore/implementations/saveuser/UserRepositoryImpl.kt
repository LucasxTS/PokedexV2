package com.example.data.dataStore.implementations.saveuser

import com.example.data.dataStore.AppDataStore
import com.example.domain.models.User
import com.example.domain.repositories.datastore.user.UserRepository

class UserRepositoryImpl(private val dataStore: AppDataStore) : UserRepository {
    override suspend fun saveUser(user: User) {
        dataStore.saveUser(user)
    }

    override suspend fun getUser(uuid: String): User? {
        return dataStore.getUser(uuid)
    }
}