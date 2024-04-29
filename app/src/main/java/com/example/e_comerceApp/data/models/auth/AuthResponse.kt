package com.example.e_comerceApp.data.models.auth

import com.google.gson.annotations.SerializedName

data class AuthResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("token")
	val token: String? = null
)

