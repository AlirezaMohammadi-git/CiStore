package com.pixel_alireza.gameland.data.remote.model.store

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "StoreEntity")
@Serializable
data class StoreData(
    val name: String,
    val amount: Int,
    val price: Int,
    val imageURL: String,
    val priority: Int,
    @PrimaryKey
    val id: String,
    var productCount: Int = 1
)
