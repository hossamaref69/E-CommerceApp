package com.example.e_comerceApp.ui.activities.home.fragments.home.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_comerceApp.data.models.categoty.Category
import com.example.e_comerceApp.databinding.ItemCategoryBinding

class CategoriesRecyclerViewAdapter(var categoriesList: List<Category?>?) :
    RecyclerView.Adapter<CategoriesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category?) {
            binding.category = category
            binding.title.setBackgroundColor(Color.TRANSPARENT)
            binding.image.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = categoriesList?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoriesList?.get(position)
        holder.bind(category)

    }
}