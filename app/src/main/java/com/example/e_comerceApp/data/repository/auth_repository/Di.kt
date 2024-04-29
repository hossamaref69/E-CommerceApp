package com.example.e_comerceApp.data.repository.auth_repository

import com.example.e_comerceApp.domain.repository.auth_repo.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class Di {

    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}