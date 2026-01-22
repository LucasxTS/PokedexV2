package com.example.data.dataStore

import com.example.domain.dataStore.DataStoreFirstAccessRepository

class DataStoreFirstAccessRepositoryImpl(private val dataStore: AppDataStore): DataStoreFirstAccessRepository {

    override suspend fun hasAlreadyAccessed() =
        dataStore.hasAlreadyAccessed()

    override suspend fun setFirstAccess() {
        dataStore.setFirstAccess()
    }
}