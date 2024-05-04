package com.example.e_comerceApp.ui.activities.home.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.e_comerceApp.R
import com.example.e_comerceApp.data.models.categoty.Category
import com.example.e_comerceApp.databinding.FragmentHomeBinding
import com.example.e_comerceApp.ui.activities.home.fragments.home.adapters.CategoriesRecyclerViewAdapter
import com.example.e_comerceApp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeFragmentViewModel by viewModels<HomeFragmentViewModel>()
    private val categoriesAdapter = CategoriesRecyclerViewAdapter(null)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderUi()
        initCategoriesRecyclerView()
    }

    private fun renderUi() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeFragmentState.CategoriesLoading -> bindCategories(state.categoriesList)
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    private fun initCategoriesRecyclerView() {
        binding.categoriesRecyclerView.adapter = categoriesAdapter
        viewModel.invoke(HomeFragmentAction.GetAllCategories)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun bindCategories(categoriesList: List<Category?>?) {
        if (categoriesList.isNullOrEmpty()) return
        Handler(Looper.getMainLooper()).postDelayed({
            binding.categoriesRecyclerViewShimmer.stopShimmer()
            binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
            categoriesAdapter.categoriesList = categoriesList
            categoriesAdapter.notifyDataSetChanged()
        }, 1000)
    }

}