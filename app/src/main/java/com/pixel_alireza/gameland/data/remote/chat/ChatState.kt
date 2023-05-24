package com.pixel_alireza.gameland.data.remote.chat


data class ChatState(
    var messages: List<Message> = emptyList(),
    var isLoading: Boolean = false
)