package com.pixel_alireza.gameland.data.remote.model.store

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "StoreEntity")
@Serializable
data class StoreData(
    val name: String,
    val price: Int,
    val imageURL: String,
    @PrimaryKey
    val id: String,
    val discountedPrice : Int = 0 ,
//    // we use this tag for chip list filtering :
//    val tag : String ,
    // this one is used for purchase :
    var productCount: Int = 1
)

