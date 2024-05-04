package com.example.e_comerceApp.data.data_sources.remote

import android.util.Log
import com.example.e_comerceApp.data.api.WebServices
import com.example.e_comerceApp.data.models.auth.AuthResponse
import com.example.e_comerceApp.data.models.auth.LoginRequest
import com.example.e_comerceApp.data.models.auth.RegisterRequest
import com.example.e_comerceApp.data.models.categoty.Category
import com.example.e_comerceApp.data.utils.SharedPreferenceHelper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val webServices: WebServices,
    private val sharedPreferenceHelper: SharedPreferenceHelper
) : RemoteDataSource {

    override suspend fun login(email: String, password: String){
        try {
            val authResponse = webServices.login(LoginRequest(email, password))
            sharedPreferenceHelper.saveToken(authResponse.token!!)
        }catch (e: Exception){
            throw e
        }
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

    override suspend fun getAllCategories(): List<Category?> {
        try {
            val categoriesResponse = webServices.getAllCategories()
            return categoriesResponse.data ?: emptyList()

        }catch (e: Exception){
            throw e
        }
    }

}