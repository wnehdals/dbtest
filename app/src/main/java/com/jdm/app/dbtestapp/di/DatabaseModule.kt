package com.jdm.app.dbtestapp.di

import android.content.Context
import androidx.room.Room
import com.jdm.app.dbtestapp.local.AppDatabase
import com.jdm.app.dbtestapp.local.LocalFoodDataSource
import com.jdm.app.dbtestapp.local.dao.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "DBTextApp.db")
            .allowMainThreadQueries()
            .build()
    }
    @Provides
    @Singleton
    fun provideFoodDao(appDatabase: AppDatabase): FoodDao {
        return appDatabase.foodDao()
    }

    @Provides
    @Singleton
    fun provideLocalFoodDataSource(foodDao: FoodDao): LocalFoodDataSource {
        return LocalFoodDataSource(foodDao)
    }
}