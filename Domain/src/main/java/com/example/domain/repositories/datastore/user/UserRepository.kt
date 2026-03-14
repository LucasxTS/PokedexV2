package com.example.domain.repositories.datastore.user

import com.example.domain.models.User

interface UserRepository {
    suspend fun saveUser(user: User)
    suspend fun getUser(uuid: String): User?
}