package com.example.domain.usecases.datastore.firstaccess

import com.example.domain.repositories.datastore.firstaccess.DataStoreFirstAccessRepository

class GetUserFirstAccessUseCase(private val repository: DataStoreFirstAccessRepository) {

    suspend operator fun invoke() = repository.userHasAlreadyHaveAccess()

}