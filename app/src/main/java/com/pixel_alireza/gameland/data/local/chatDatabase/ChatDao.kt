package com.pixel_alireza.gameland.data.local.chatDatabase

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pixel_alireza.gameland.data.remote.chat.Message


@Dao
interface ChatDao {
    @Query("SELECT *  FROM Message_table")
    suspend fun getPreviousMessages(): List<Message>

    @Upsert
    suspend fun insertMessage(message: Message)

    @Query("DELETE FROM Message_table")
    suspend fun deleteAllMessages()

    @Upsert
    suspend fun addMessageList(messages: List<Message>)

}