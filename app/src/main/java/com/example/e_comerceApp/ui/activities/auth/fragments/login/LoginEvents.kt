package com.example.e_comerceApp.ui.activities.auth.fragments.login

sealed class LoginEvents {

    data object SuccessfulLogin : LoginEvents()

    data object NavigateToRegisterFragment : LoginEvents()
}
