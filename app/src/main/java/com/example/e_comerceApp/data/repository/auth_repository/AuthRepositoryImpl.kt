package com.example.e_comerceApp.data.repository.auth_repository

import com.example.e_comerceApp.data.data_sources.remote.RemoteDataSource
import com.example.e_comerceApp.domain.repository.auth_repo.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : AuthRepository {

    override suspend fun login(email: String, password: String) {
        remoteDataSource.login(email, password)
    }

    override suspend fun register(
        name: String,
        mobileNumber: String,
        email: String,
        password: String,
        repassword: String
    ) {
        remoteDataSource.register(
            name = name,
            mobileNumber = mobileNumber,
            email = email,
            password = password,
            rePassword = repassword
        )
    }

}