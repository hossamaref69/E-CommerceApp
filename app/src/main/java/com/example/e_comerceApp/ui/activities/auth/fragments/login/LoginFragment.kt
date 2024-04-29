package com.example.e_comerceApp.ui.activities.auth.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e_comerceApp.ui.HomeActivity
import com.example.e_comerceApp.R
import com.example.e_comerceApp.databinding.FragmentLoginBinding
import com.example.e_comerceApp.ui.activities.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        observe()
    }

    override fun getLayoutId(): Int = R.layout.fragment_login

    private fun observe(){
        viewModel.events.observe(viewLifecycleOwner){
            it?.let {
                when(it){
                    LoginEvents.SuccessfulLogin -> {
                       startActivity( Intent(activity, HomeActivity::class.java))
                   }
                    LoginEvents.NavigateToRegisterFragment -> {
                        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                    }
                }
            }
        }

        viewModel.isLoadingLiveData.observe(viewLifecycleOwner){
            if (it){
                showLoading()
            } else{
                hideLoading()
            }
        }

        viewModel.viewMessageLiveData.observe(viewLifecycleOwner){
            showDialog(
                it.title,
                it.message,
                it.posButtonTitle,
                it.negButtonTitle,
                it.onPosButtonClick,
                it.onNegButtonClick
            )
        }

    }
}