package com.example.domain.dataStore

 interface DataStoreFirstAccessRepository {
     suspend fun userHasAlreadyHaveAccess(): Boolean
}