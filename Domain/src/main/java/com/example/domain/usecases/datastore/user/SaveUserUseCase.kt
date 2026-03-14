package com.example.domain.usecases.datastore.user

import com.example.domain.models.User
import com.example.domain.repositories.datastore.user.UserRepository

class SaveUserUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(user: User) = repository.saveUser(user)
}