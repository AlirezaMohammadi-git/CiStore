package com.pixel_alireza.gameland.data.remote.repo.chat

import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.chat.Message
import com.pixel_alireza.gameland.utils.Constants
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initializeSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()


    sealed class endPoints(val url: String) {
        object chat : endPoints("${Constants.WS_BASE_URL}/globalChat")
    }

}