package com.pixel_alireza.gameland.data.remote.repo.chat

import com.pixel_alireza.gameland.data.remote.Common
import com.pixel_alireza.gameland.data.remote.chat.Message
import com.pixel_alireza.gameland.utils.Constants

interface MessageDataSource {

    suspend fun getAllMessages(page: Int): Common<List<Message>>

    suspend fun deleteAllMessages(): Common<Unit>

    sealed class endPoints(val url: String) {
        object GetAllMessages : endPoints("${{Constants.NORMAL_BASE_URL}}/getMessages")
    }

}