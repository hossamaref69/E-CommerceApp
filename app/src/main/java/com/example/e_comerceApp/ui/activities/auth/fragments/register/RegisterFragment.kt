package com.example.e_comerceApp.ui.activities.auth.fragments.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.e_comerceApp.R
import com.example.e_comerceApp.databinding.FragmentRegisterBinding
import com.example.e_comerceApp.ui.HomeActivity
import com.example.e_comerceApp.ui.activities.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    private val viewModel: RegisterViewModel by viewModels<RegisterViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        observe()
    }

    private fun observe() {
        viewModel.isLoadingLiveData.observe(viewLifecycleOwner) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }

        viewModel.viewMessageLiveData.observe(viewLifecycleOwner) {
            showDialog(
                it.title,
                it.message,
                it.posButtonTitle,
                it.negButtonTitle,
                it.onPosButtonClick,
                it.onNegButtonClick
            )
        }

        viewModel.events.observe(viewLifecycleOwner) {
            if (it is RegisterEvents.NavigateToHomeScreen) {
                startActivity(Intent(activity, HomeActivity::class.java))
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_register
}