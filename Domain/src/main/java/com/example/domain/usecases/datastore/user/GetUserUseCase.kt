package com.example.domain.usecases.datastore.user

import com.example.domain.repositories.datastore.user.UserRepository

class GetUserUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(uuid: String) = repository.getUser(uuid)
}