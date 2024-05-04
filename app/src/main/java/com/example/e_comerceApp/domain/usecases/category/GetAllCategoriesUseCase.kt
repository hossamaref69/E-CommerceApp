package com.example.e_comerceApp.domain.usecases.category

import com.example.e_comerceApp.data.models.categoty.Category
import com.example.e_comerceApp.domain.repository.caregory_repository.CategoryRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute(): List<Category?>{
        return categoryRepository.getAllCategory()
    }
}