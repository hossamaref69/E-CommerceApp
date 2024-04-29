package com.example.e_comerceApp.ui.activities.auth.fragments.register

sealed class RegisterEvents {
    data object NavigateToHomeScreen : RegisterEvents()
}