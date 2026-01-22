package com.example.domain.dataStore

 interface DataStoreFirstAccessRepository {
     suspend fun hasAlreadyAccessed(): Boolean
     suspend fun setFirstAccess()
}