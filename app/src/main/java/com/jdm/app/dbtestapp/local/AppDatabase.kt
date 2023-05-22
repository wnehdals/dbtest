package com.jdm.app.dbtestapp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jdm.app.dbtestapp.entity.FoodEntity
import com.jdm.app.dbtestapp.local.dao.FoodDao

@Database(
    entities = [FoodEntity::class], version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun foodDao(): FoodDao
}