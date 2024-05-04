package com.example.e_comerceApp.ui.activities.home.fragments.home

sealed class HomeFragmentAction {
    data object GetAllCategories : HomeFragmentAction()
}