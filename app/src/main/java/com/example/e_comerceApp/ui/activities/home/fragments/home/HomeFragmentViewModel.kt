package com.example.e_comerceApp.ui.activities.home.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_comerceApp.domain.usecases.category.GetAllCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) : ViewModel() {


    val state = MutableLiveData<HomeFragmentState>()
    fun invoke(action: HomeFragmentAction){
        when (action) {
            HomeFragmentAction.GetAllCategories -> getAllCategories()
        }
    }

    private fun getAllCategories() {
        viewModelScope.launch {
            try {
                state.value = HomeFragmentState.CategoriesLoading(
                    getAllCategoriesUseCase.execute()
                )
            } catch (e: Exception) {
                throw e
            }
        }
    }
}