package com.example.e_comerceApp.ui.activities.home.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import com.example.e_comerceApp.R
import com.example.e_comerceApp.databinding.FragmentHomeBinding
import com.example.e_comerceApp.ui.activities.home.fragments.home.adapters.CategoriesRecyclerViewAdapter
import com.example.e_comerceApp.ui.base.BaseFragment
import com.example.e_comerceApp.ui.models.ElectronicsOffers
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeFragmentViewModel by viewModels<HomeFragmentViewModel>()
    private val adapter = CategoriesRecyclerViewAdapter(listOf())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderUi()
        initCategoriesRecyclerView()
    }


    private fun initCategoriesRecyclerView() {
        binding.categoriesRecyclerView.adapter = adapter
        viewModel.invoke(HomeFragmentAction.LoadOfferProducts)
    }

    private fun renderUi(){
        viewModel.state.observe(viewLifecycleOwner){ state ->
            when(state){
                is HomeFragmentState.LoadOfferProducts -> bindCategories(state.listProducts)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun bindCategories(productsList: List<ElectronicsOffers?>?) {
        if (productsList.isNullOrEmpty()) return
        Handler(Looper.getMainLooper()).postDelayed({
            binding.categoriesRecyclerViewShimmer.stopShimmer()
            binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
            adapter.categoriesList = productsList
            adapter.notifyDataSetChanged()
        }, 1000)
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

}