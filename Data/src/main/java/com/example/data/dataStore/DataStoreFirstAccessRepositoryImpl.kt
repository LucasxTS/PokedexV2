package com.example.data.dataStore

import com.example.domain.dataStore.repository.DataStoreFirstAccessRepository

class DataStoreFirstAccessRepositoryImpl(private val dataStore: AppDataStore): DataStoreFirstAccessRepository {

    override suspend fun userHasAlreadyHaveAccess(): Boolean {
        return dataStore.checkAndMarkFirstAccess()
    }
}