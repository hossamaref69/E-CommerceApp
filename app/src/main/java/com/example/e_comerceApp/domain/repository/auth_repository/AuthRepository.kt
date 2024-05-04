package com.example.e_comerceApp.domain.repository.auth_repository

interface AuthRepository {

    suspend fun login(email: String, password: String)

    suspend fun register(
        name: String,
        mobileNumber: String,
        email: String,
        password: String,
        rePassword: String
    )
}