package com.pixel_alireza.gameland.data.local.chatDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pixel_alireza.gameland.data.remote.chat.Message


@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
}