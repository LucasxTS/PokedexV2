package com.example.domain.dataStore.useCase

import com.example.domain.dataStore.repository.DataStoreFirstAccessRepository

class GetUserFirstAccessUseCase(private val repository: DataStoreFirstAccessRepository) {

    suspend operator fun invoke() = repository.userHasAlreadyHaveAccess()

}