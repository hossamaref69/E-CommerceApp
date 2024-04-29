package com.example.e_comerceApp.data.data_sources.remote

import android.util.Log
import com.example.e_comerceApp.data.api.WebServices
import com.example.e_comerceApp.data.models.auth.AuthResponse
import com.example.e_comerceApp.data.models.auth.LoginRequest
import com.example.e_comerceApp.data.models.auth.RegisterRequest
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) : RemoteDataSource {

    override suspend fun login(email: String, password: String): AuthResponse {
        return webServices.login(LoginRequest(email, password))
    }

    override suspend fun register(
        name: String,
        mobileNumber: String,
        email: String,
        password: String,
        rePassword: String
    ) {
        return webServices.register(RegisterRequest(name, mobileNumber, email, password, rePassword))
    }

}