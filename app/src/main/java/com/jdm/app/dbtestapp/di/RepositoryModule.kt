package com.jdm.app.dbtestapp.di

import com.jdm.app.dbtestapp.repository.FoodRepository
import com.jdm.app.dbtestapp.repository.FoodRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFoodRepository(
        foodRepository: FoodRepositoryImpl
    ): FoodRepository
}