package com.example.domain.models

data class User(
    val uuid: String,
    val name: String?,
    val email: String?,
    val favoritePokemonList: List<Int>
)
