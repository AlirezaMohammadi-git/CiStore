package com.pixel_alireza.gameland.data.remote.repo.chat

import com.pixel_alireza.gameland.data.remote.Common
import com.pixel_alireza.gameland.data.remote.chat.Message
import com.pixel_alireza.gameland.data.remote.chat.MessageDto
import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class MessageDataSourceImpl(
    private val client: HttpClient
) : MessageDataSource {
    override suspend fun getAllMessages(page: Int): Common<List<Message>> {
        return try {
            val result = client.get<Common<List<MessageDto>>> {
                url(MessageDataSource.endPoints.GetAllMessages.url)
                parameter("page", page)
            }
            Common(res = true, data = result.data?.map { messageDto ->
                messageDto.toMessage()
            })
        } catch (e: Exception) {
            e.printStackTrace()
            Common(false, "something went wrong")
        }

    }

    override suspend fun deleteAllMessages(): Common<Unit> {
        return try {
            client.delete<Common<Unit>> {
                url(MessageDataSource.endPoints.DeleteAllMessages.url)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Common(false, "something went wrong")
        }
    }
}