package com.example.domain.repositories.datastore.firstaccess

interface DataStoreFirstAccessRepository {
    suspend fun userHasAlreadyHaveAccess(): Boolean
}