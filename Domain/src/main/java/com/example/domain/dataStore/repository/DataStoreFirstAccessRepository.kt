package com.example.domain.dataStore.repository

interface DataStoreFirstAccessRepository {
    suspend fun userHasAlreadyHaveAccess(): Boolean
}