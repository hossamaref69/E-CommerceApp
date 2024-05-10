package com.example.e_comerceApp.ui.activities.home.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_comerceApp.ui.models.ElectronicsOffers

class HomeFragmentViewModel : ViewModel() {

    val state = MutableLiveData<HomeFragmentState>()

    fun invoke(action: HomeFragmentAction){
        when(action){
            is HomeFragmentAction.LoadOfferProducts -> loadOffersProducts()
        }
    }

    private fun loadOffersProducts() {
        state.value = HomeFragmentState.LoadOfferProducts(ElectronicsOffers.productsList)
    }
}