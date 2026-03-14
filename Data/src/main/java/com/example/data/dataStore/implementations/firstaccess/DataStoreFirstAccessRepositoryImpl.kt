package com.example.data.dataStore.implementations.firstaccess

import com.example.data.dataStore.AppDataStore
import com.example.domain.repositories.datastore.firstaccess.DataStoreFirstAccessRepository

class DataStoreFirstAccessRepositoryImpl(private val dataStore: AppDataStore):
    DataStoreFirstAccessRepository {

    override suspend fun userHasAlreadyHaveAccess(): Boolean {
        return dataStore.checkAndMarkFirstAccess()
    }
}