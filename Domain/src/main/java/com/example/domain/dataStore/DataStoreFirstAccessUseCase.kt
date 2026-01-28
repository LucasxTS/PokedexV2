package com.example.domain.dataStore

class GetUserFirstAccessUseCase(private val repository: DataStoreFirstAccessRepository) {

    suspend operator fun invoke() = repository.userHasAlreadyHaveAccess()

}