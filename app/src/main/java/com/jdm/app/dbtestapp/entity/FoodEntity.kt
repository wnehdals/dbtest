package com.jdm.app.dbtestapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val name: String,
    val kcal: Int
)