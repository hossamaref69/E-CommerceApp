package com.example.e_comerceApp.data.repository.category_repository

import com.example.e_comerceApp.domain.repository.caregory_repository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun provideCategoriesRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository
}