package com.example.e_comerceApp.ui.activities.auth.fragments.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_comerceApp.domain.usecases.auth.RegisterUseCase
import com.example.e_comerceApp.ui.models.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) : ViewModel() {

    var nameLiveData = MutableLiveData("")
    var mobileNumberLiveData = MutableLiveData("")
    var emailLiveData = MutableLiveData("")
    var passwordLiveData = MutableLiveData("")
    var rePasswordLiveData = MutableLiveData("")
    var isLoadingLiveData = MutableLiveData<Boolean>()
    var viewMessageLiveData = MutableLiveData<ViewMessage>()
    var events = MutableLiveData<RegisterEvents>()

    var nameErrorLiveData = MutableLiveData<String?>()
    var mobileNumberErrorLiveData = MutableLiveData<String?>()
    var emailErrorLiveData = MutableLiveData<String?>()
    var passwordErrorLiveData = MutableLiveData<String?>()

    fun singUp() {
        viewModelScope.launch {
            try {
                isLoadingLiveData.value = true
                registerUseCase.name = nameLiveData.value!!
                registerUseCase.mobileNumber = mobileNumberLiveData.value!!
                registerUseCase.email = emailLiveData.value!!
                registerUseCase.password = passwordLiveData.value!!
                registerUseCase.rePassword = rePasswordLiveData.value!!
                registerUseCase.execute()
                isLoadingLiveData.value = false
                events.value = RegisterEvents.NavigateToHomeScreen

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

}