package com.jdm.app.dbtestapp.repository

import com.jdm.app.dbtestapp.entity.FoodEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface FoodRepository {
    fun loadAllFoodEntity(): Single<List<FoodEntity>>
    fun deleteFoodEntity(foodEntity: FoodEntity): Completable
    fun insertFoodEntity(foodEntity: FoodEntity): Completable
    fun updateFoodEntity(foodEntity: FoodEntity): Completable
}