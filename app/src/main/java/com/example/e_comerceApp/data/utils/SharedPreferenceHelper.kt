package com.example.e_comerceApp.data.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun saveToken(token: String) {
        with(sharedPreferences.edit()) {
            putString("token", token)
            apply()
        }
    }

    fun getToken(): String? {
       return sharedPreferences.getString("token", null)
    }
}