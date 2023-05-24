package com.pixel_alireza.gameland.data.remote.chat

import com.pixel_alireza.gameland.data.remote.chat.Message
import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    val id: String,
    val text: String,
    val timestamp: Long,
    val username: String
) {
    fun toMessage(): Message {
        return Message(
            text = text,
            username = username,
            timestamp = timestamp
        )
    }
}

