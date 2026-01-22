package com.example.domain.dataStore

class GetUserFirstAccessUseCase(private val repository: DataStoreFirstAccessRepository) {

    suspend fun hasAlreadyAccessed() = repository.hasAlreadyAccessed()

    suspend fun setFirstAccess() = repository.setFirstAccess()
}