package com.pixel_alireza.gameland.data.remote.model.chat

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "Message_table")
@Serializable
data class Message(
    val text: String,
    val username: String,
    val timestamp: Long,
    @PrimaryKey
    val id: String
)