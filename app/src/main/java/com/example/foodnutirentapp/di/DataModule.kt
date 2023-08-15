package com.example.foodnutirentapp.di

import com.example.foodnutirentapp.data.remote.ApiService
import com.example.foodnutirentapp.data.repo.RemoteRepositoryImpl
import com.example.foodnutirentapp.domain.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesRepository(apiService: ApiService): RemoteRepository {
        return RemoteRepositoryImpl(apiService)
    }


}