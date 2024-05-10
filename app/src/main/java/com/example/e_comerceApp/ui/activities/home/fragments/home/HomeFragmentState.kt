package com.example.e_comerceApp.ui.activities.home.fragments.home

import com.example.e_comerceApp.ui.models.ElectronicsOffers

sealed class HomeFragmentState {
    class LoadOfferProducts(val listProducts: List<ElectronicsOffers>) : HomeFragmentState()
}