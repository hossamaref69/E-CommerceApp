package com.example.e_comerceApp.data.models.auth

data class RegisterRequest (
    val name: String,
    val mobileNumber: String,
    val email: String,
    val password: String,
    val rePassword: String
)