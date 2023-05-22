package com.jdm.app.dbtestapp.local

import com.jdm.app.dbtestapp.entity.FoodEntity
import com.jdm.app.dbtestapp.local.dao.FoodDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalFoodDataSource @Inject constructor(
    private val foodDao: FoodDao
) {
    fun insert(foodEntity: FoodEntity): Completable {
        return foodDao.insert(foodEntity)
    }

    fun update(foodEntity: FoodEntity): Completable {
        return foodDao.update(foodEntity)
    }

    fun delete(foodEntity: FoodEntity): Completable {
        return foodDao.delete(foodEntity)
    }

    fun loadAll(): Single<List<FoodEntity>> {
        return foodDao.loadALl()
    }
}