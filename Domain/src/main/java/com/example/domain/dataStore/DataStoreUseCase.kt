package com.example.domain.dataStore

 interface DataStoreUseCase {
     suspend fun hasAlreadyAccessed(): Boolean
     suspend fun setFirstAccess()
}