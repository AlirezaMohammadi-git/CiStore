package com.pixel_alireza.gameland.data.remote.repo.chat.message

import com.pixel_alireza.gameland.data.remote.model.Common
import com.pixel_alireza.gameland.data.remote.model.chat.Message
import com.pixel_alireza.gameland.utils.Constants
import javax.inject.Inject

interface MessageDataSource{

    suspend fun getAllMessages(page:Int) : Common<List<Message>>

    sealed class endPoints(val url: String) {

        object getAllMessages : endPoints("${Constants.NORMAL_BASE_URL}/getMessages")

    }

}