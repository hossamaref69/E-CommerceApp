package com.example.e_comerceApp.ui.activities.home.fragments.home

import com.example.e_comerceApp.data.models.categoty.Category

sealed class HomeFragmentState {
    data class CategoriesLoading(val categoriesList: List<Category?>) : HomeFragmentState()
}