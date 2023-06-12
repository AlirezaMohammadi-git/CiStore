package com.pixel_alireza.gameland.data.remote.repo.chat.message

import android.util.Log
import com.pixel_alireza.gameland.data.remote.model.Common
import com.pixel_alireza.gameland.data.remote.model.chat.Message
import com.pixel_alireza.gameland.utils.TAG
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import javax.inject.Inject

class MessageDataSourceImpl @Inject constructor(private val client: HttpClient) : MessageDataSource {
    override suspend fun getAllMessages(page: Int): Common<List<Message>> {
        return try {
            client.get<Common<List<Message>>> {
                url(MessageDataSource.endPoints.getAllMessages.url)
                parameter("page",page)
            }
        } catch (e: Exception) {
            Log.e(TAG.Error.tag, "getAllMessages: ${e.message}")
            Common(false, e.message, null)
        }
    }
}