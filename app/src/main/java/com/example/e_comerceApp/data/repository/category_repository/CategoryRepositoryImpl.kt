package com.example.e_comerceApp.data.repository.category_repository

import com.example.e_comerceApp.data.data_sources.remote.RemoteDataSource
import com.example.e_comerceApp.data.models.categoty.Category
import com.example.e_comerceApp.domain.repository.caregory_repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): CategoryRepository {
    override suspend fun getAllCategory(): List<Category?> {
        return remoteDataSource.getAllCategories()
    }

}