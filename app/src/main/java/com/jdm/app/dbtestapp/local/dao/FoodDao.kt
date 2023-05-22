package com.jdm.app.dbtestapp.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jdm.app.dbtestapp.entity.FoodEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(foodEntity: FoodEntity): Completable

    @Update
    fun update(foodEntities: FoodEntity): Completable

    @Delete
    fun delete(foodEntity: FoodEntity): Completable

    @Query("SELECT * FROM FOOD ORDER BY ID ASC")
    fun loadALl(): Single<List<FoodEntity>>

}