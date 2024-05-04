package com.example.e_comerceApp.domain.repository.caregory_repository

import com.example.e_comerceApp.data.models.categoty.Category

interface CategoryRepository {
    suspend fun getAllCategory(): List<Category?>
}