package com.example.e_comerceApp.data.api

import com.example.e_comerceApp.data.models.auth.AuthResponse
import com.example.e_comerceApp.data.models.auth.LoginRequest
import com.example.e_comerceApp.data.models.auth.RegisterRequest
import com.example.e_comerceApp.data.models.categoty.CategoriesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.Locale.Category

interface WebServices {

    @POST("/api/v1/auth/signin")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): AuthResponse

    @POST("/api/v1/auth/signup")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    )

    @GET("/api/v1/categories")
    suspend fun getAllCategories(): CategoriesResponse

}