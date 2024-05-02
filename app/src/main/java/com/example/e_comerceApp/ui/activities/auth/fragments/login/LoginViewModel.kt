package com.example.e_comerceApp.ui.activities.auth.fragments.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_comerceApp.domain.usecases.auth.LoginUseCase
import com.example.e_comerceApp.ui.models.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {
    var emailLiveData = MutableLiveData("")
    var passwordLiveData = MutableLiveData("")
    var emailErrorLiveData = MutableLiveData<String?>()
    var passwordErrorLiveData = MutableLiveData<String?>()
    var isLoadingLiveData = MutableLiveData<Boolean>()
    var viewMessageLiveData = MutableLiveData<ViewMessage>()
    var events = MutableLiveData<LoginEvents?>()

    fun login(){
        if (!validate()) return
        viewModelScope.launch {
            try {
                isLoadingLiveData.value = true
                loginUseCase.email = emailLiveData.value!!
                loginUseCase.password = passwordLiveData.value!!
                loginUseCase.execute()
                isLoadingLiveData.value = false
                events.value = LoginEvents.SuccessfulLogin
            }catch (e: Exception){
                isLoadingLiveData.value = false
                viewMessageLiveData.value = ViewMessage(
                    title = "Error",
                    message = e.message,
                    negButtonTitle = "Ok"
                )
            }
        }
    }

    private fun validate(): Boolean{
        var isValid = true

        if (emailLiveData.value.isNullOrEmpty()){
            emailErrorLiveData.value = "Pleas enter your email"
            isValid = false
        }else {
            emailErrorLiveData.value = ""
        }

        if (passwordLiveData.value.isNullOrEmpty()){
            passwordErrorLiveData.value = "Pleas enter your password"
            isValid = false
        }else {
            passwordErrorLiveData.value = ""
        }

        return isValid
    }

    fun creatAcconut(){
        events.value = LoginEvents.NavigateToRegisterFragment
        events.value = null
    }
}