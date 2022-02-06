package com.example.jetpackcomposevideogamesdemo.injection

import com.example.jetpackcomposevideogamesdemo.data.repository.HomeRepositoryImpl
import com.example.jetpackcomposevideogamesdemo.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun providesHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}