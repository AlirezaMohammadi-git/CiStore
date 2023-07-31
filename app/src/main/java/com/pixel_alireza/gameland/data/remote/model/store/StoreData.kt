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
    val gameTag : String ,
    @PrimaryKey
    val id: String,
    //this one is the more expensive price
    var discountedPrice : Int = 0 ,
    // this one is used for purchase and will send to server to save for user cart :
    var productCount: Int = 1   ,
    // this one is used for purchase and will send to server to save for user cart :
    var coinCount : Int = 0
)

