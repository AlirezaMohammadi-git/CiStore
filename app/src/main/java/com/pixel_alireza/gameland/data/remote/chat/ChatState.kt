package com.pixel_alireza.gameland.data.remote.chat

import kotlinx.serialization.Serializable

@Serializable
data class ChatState(
    var messages: List<Message> = emptyList(),
    var isLoading: Boolean = false
)