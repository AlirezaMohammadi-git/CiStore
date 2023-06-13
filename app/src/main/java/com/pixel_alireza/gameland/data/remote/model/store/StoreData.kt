package com.pixel_alireza.gameland.data.remote.model.store

import androidx.compose.runtime.mutableStateOf
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pixel_alireza.gameland.data.local.model.UIFeatures.ChipDetail
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

) {
    fun toChipUsage(): ChipDetail {
        return ChipDetail(name, mutableStateOf(false))
    }
}

