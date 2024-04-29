package com.example.e_comerceApp.domain.usecases.auth

import com.example.e_comerceApp.domain.repository.auth_repo.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private var authRepo: AuthRepository
) {
    var email = ""
    var password = ""

     suspend fun execute(){
        authRepo.login(email, password)
    }
}