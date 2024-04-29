package com.example.e_comerceApp.data.data_sources.remote

import com.example.e_comerceApp.data.models.auth.AuthResponse

interface RemoteDataSource {
    suspend fun login(email: String, password: String): AuthResponse

    suspend fun register(
        name: String,
        mobileNumber: String,
        email: String,
        password: String,
        rePassword: String
    )
}