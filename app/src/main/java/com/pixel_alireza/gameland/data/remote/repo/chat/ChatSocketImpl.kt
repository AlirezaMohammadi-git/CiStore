package com.pixel_alireza.gameland.data.remote.repo.chat

import android.util.Log
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.chat.Message
import com.pixel_alireza.gameland.data.remote.chat.MessageDto
import com.pixel_alireza.gameland.utils.TAG
import io.ktor.client.HttpClient
import io.ktor.client.features.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession
import io.ktor.http.cio.websocket.close
import io.ktor.http.cio.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.isActive
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ChatSocketImpl @Inject constructor(
    private val client: HttpClient
) : ChatSocketService {
    private var socket: WebSocketSession? = null
    override suspend fun initializeSession(username: String): Resource<Unit> {
        return try {
            Log.e(TAG.Error.tag, "initializeSession: $username")
            socket = client.webSocketSession {
                url("${ChatSocketService.endPoints.chat.url}?username=$username")
            }
            if (socket?.isActive == true) {
                Log.e(TAG.Error.tag, "socket is active: $username")
                Resource.Success(Unit)
            } else {
                Resource.Error("Couldn't establish connection")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Unknown Error")
        }
    }

    override suspend fun sendMessage(message: String) {
        try {
            socket?.send(Frame.Text(message))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun observeMessages(): Flow<Message> {
        return try {
            socket?.incoming
                ?.receiveAsFlow()
                ?.filter { it is Frame.Text }
                ?.map { frame ->
                    val string = (frame as? Frame.Text)?.readText() ?: ""
                    Json.decodeFromString<MessageDto>(string)
                        .toMessage()
                } ?: flow { }
        } catch (e: Exception) {
            e.printStackTrace()
            flow { }
        }
    }

    override suspend fun closeSession() {
        socket?.close()
    }
}