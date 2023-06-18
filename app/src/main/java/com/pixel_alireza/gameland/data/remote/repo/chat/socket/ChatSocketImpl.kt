package com.pixel_alireza.gameland.data.remote.repo.chat.socket

import android.content.Context
import android.util.Log
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.model.chat.Message
import com.pixel_alireza.gameland.utils.NoInternetException
import com.pixel_alireza.gameland.utils.TAG
import io.ktor.client.HttpClient
import io.ktor.client.features.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession
import io.ktor.http.cio.websocket.close
import io.ktor.http.cio.websocket.readText
import ir.dunijet.broadcastreceiver.NetworkChecker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
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
    private var isSocketActive = MutableSharedFlow<Boolean>()
    private var network = MutableSharedFlow<Boolean>()
    override suspend fun initializeSession(username: String, context: Context): Resource<Unit> {
        return try {
            if (NetworkChecker(context).isInternetConnected) {
                Log.i(TAG.Info.tag, "initializeSession with user name $username is started!")
                socket = client.webSocketSession {
                    url("${ChatSocketService.endPoints.chat.url}?username=$username")
                }
                if (socket?.isActive == true) {
                    Log.i(TAG.Info.tag, "socket activated for $username")
                    isSocketActive.emit(true)
                    Resource.Success(Unit)
                } else {
                    isSocketActive.emit(false)
                    Resource.Error("Couldn't establish connection")
                }
            } else {
                network.emit(false)
                throw NoInternetException()
            }

        } catch (e: Exception) {
            Log.e(TAG.Error.tag, "initializeSession: ${e.message}")
            isSocketActive.emit(false)
            Resource.Error(e.localizedMessage ?: "Unknown Error")
        } catch (e: NoInternetException) {
            Resource.Error("No internet connection")
        }
    }



    override suspend fun sendMessage(message: String) {
        try {
            socket?.send(Frame.Text(message))
            Log.d(TAG.Warning.tag, "sendMessage: $message")
        } catch (e: Exception) {
            Log.d(TAG.Error.tag, "sendMessage(error): ${e.message}")
        }
    }

    override fun observeMessages(): Flow<Message> {
        return try {
            socket?.incoming
                ?.receiveAsFlow()
                ?.filter { it is Frame.Text }
                ?.map { frame ->
                    val string = (frame as? Frame.Text)?.readText() ?: ""
                    Json.decodeFromString<Message>(string)
                } ?: flow { }
        } catch (e: Exception) {
            e.printStackTrace()
            flow { }
        }
    }

    override fun isSessionActive(): SharedFlow<Boolean> {
        return isSocketActive
    }

    override suspend fun closeSession() {
        socket?.close()
        Log.d(TAG.Info.tag, "closeSession: session closed!")
    }

}