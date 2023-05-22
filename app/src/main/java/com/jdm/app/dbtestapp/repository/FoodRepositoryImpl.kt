package com.jdm.app.dbtestapp.repository

import com.jdm.app.dbtestapp.entity.FoodEntity
import com.jdm.app.dbtestapp.local.LocalFoodDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val localFoodDataSource: LocalFoodDataSource
) : FoodRepository{
    override fun loadAllFoodEntity(): Single<List<FoodEntity>> {
        return localFoodDataSource.loadAll()
    }

    override fun deleteFoodEntity(foodEntity: FoodEntity): Completable {
        return localFoodDataSource.delete(foodEntity)
    }

    override fun insertFoodEntity(foodEntity: FoodEntity): Completable {
        return localFoodDataSource.insert(foodEntity)
    }

    override fun updateFoodEntity(foodEntity: FoodEntity): Completable {
        return localFoodDataSource.update(foodEntity)
    }
}