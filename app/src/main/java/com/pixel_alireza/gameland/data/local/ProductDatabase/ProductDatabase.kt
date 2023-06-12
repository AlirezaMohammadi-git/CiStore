package com.pixel_alireza.gameland.data.local.ProductDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pixel_alireza.gameland.data.remote.model.chat.Message
import com.pixel_alireza.gameland.data.remote.model.store.StoreData


@Database(entities = [Message::class, StoreData::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun ProductDao(): ProductDao
}