package com.pixel_alireza.gameland.data.remote.chat

import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    val text: String,
    val username: String,
    val timestamp: Long,
    val id: String,
) {
    fun toMessage(): Message {
        return Message(
            text = text,
            username = username,
            timestamp = timestamp,
        )
    }
}

