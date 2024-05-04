package com.example.e_comerceApp.data.data_sources.remote

import com.example.e_comerceApp.data.models.auth.AuthResponse
import com.example.e_comerceApp.data.models.categoty.Category

interface RemoteDataSource {
    suspend fun login(email: String, password: String)

    suspend fun register(
        name: String,
        mobileNumber: String,
        email: String,
        password: String,
        rePassword: String
    )

    suspend fun getAllCategories(): List<Category?>
}