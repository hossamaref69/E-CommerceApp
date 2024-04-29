package com.example.e_comerceApp.data.api

import com.example.e_comerceApp.data.models.auth.AuthResponse
import com.example.e_comerceApp.data.models.auth.LoginRequest
import com.example.e_comerceApp.data.models.auth.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface WebServices {

    @POST("/api/v1/auth/signin")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): AuthResponse

    @POST("/api/v1/auth/signup")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    )

}