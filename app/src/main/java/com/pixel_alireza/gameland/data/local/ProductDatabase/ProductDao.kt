package com.pixel_alireza.gameland.data.local.ProductDatabase

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pixel_alireza.gameland.data.remote.model.store.StoreData


@Dao
interface ProductDao {
    @Query("SELECT *  FROM StoreEntity")
    suspend fun getAllItems(): List<StoreData>

    @Upsert
    suspend fun insertProduct( product : StoreData )

    @Query("SELECT * FROM StoreEntity WHERE id = :id")
    suspend fun getProductById(id:String) : StoreData

    @Query("DELETE FROM StoreEntity")
    suspend fun deleteAllProducts()

    @Upsert
    suspend fun addProductList(messages: List<StoreData>)

}