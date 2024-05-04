package com.example.e_comerceApp.domain.usecases.auth

import com.example.e_comerceApp.domain.repository.auth_repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
){

    var name = ""
    var mobileNumber = ""
    var email = ""
    var password = ""
    var rePassword = ""

    suspend fun execute(){
        authRepository.register(name, mobileNumber, email, password, rePassword)
    }
}