package com.pixel_alireza.gameland.presentation.Screens.globalChatScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.local.chatDatabase.ChatDao
import com.pixel_alireza.gameland.data.local.model.cache.UsernameInMemory
import com.pixel_alireza.gameland.data.remote.chat.ChatState
import com.pixel_alireza.gameland.data.remote.repo.chat.ChatSocketService
import com.pixel_alireza.gameland.data.remote.repo.chat.MessageDataSource
import com.pixel_alireza.gameland.utils.TAG
import com.pixel_alireza.gameland.utils.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatSocketService: ChatSocketService,
    private val chatDao: ChatDao, //usable when internet disconnected
    private val messageDataSource: MessageDataSource
) : ViewModel() {
    private val _toastEvent = MutableSharedFlow<String>() //mutable version
    val toastEvent = _toastEvent.asSharedFlow() //immutable version

    private val _chatsState = mutableStateOf(ChatState()) //mutable version
    val getChatsState: MutableState<ChatState> = _chatsState   //immutable version

//    private val _previousChatsState = mutableStateOf(ChatState())
//    val previousMessages : State<ChatState> = _previousChatsState


    private var pageNumber = 1
    fun increasePage() {
        pageNumber += 1
    }

    private val _messageText = mutableStateOf("")
    val messageText: State<String> = _messageText
    fun onChangeMessage(message: String) {
        _messageText.value = message
    }

    fun connectSession() {
        getPreviousMessages()
        if (UsernameInMemory.username != null) {
            viewModelScope.launch(coroutineExceptionHandler) {
                when (val initSession =
                    chatSocketService.initializeSession(UsernameInMemory.username!!)) {
                    is Resource.Error -> {
                        _toastEvent.emit("Something went wrong!")
                        Log.e(TAG.Error.tag, "connectSession: ${initSession.message}")
                    }

                    is Resource.Success -> {
                        _toastEvent.emit("socket connected!")
                        observeMessages()
                    }
                }
            }
        }
    }    //connecting to session

    fun getPreviousMessages() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _chatsState.run {
                value.isLoading = true
            }
            val res = messageDataSource.getAllMessages(pageNumber).data ?: listOf()
            val updatedMessages = _chatsState.value.messages + res
            _chatsState.value = _chatsState.value.copy(messages = updatedMessages)
            _chatsState.run {
                value = ChatState(updatedMessages, false)
            }
//            res.forEach {  message ->
//                val newList = _chatsState.value.messages.toMutableList().apply {
//                    add(this.lastIndex + 1 , message )
//                }
//                _chatsState.value = _chatsState.value.copy(messages = newList)
//            }
//            _chatsState.run {
//                value = ChatState(res, false)
//            }
//            chatDao.addMessageList(messageDataSource.getAllMessages(1).data ?: listOf())
        }
    }

    private fun observeMessages() {
        chatSocketService.observeMessages()
            .onEach { message ->
                //reversed list -> new messages will show in bottom
                val newList = _chatsState.value.messages.toMutableList().apply {
                    add(0, message)
                }
                _chatsState.value = _chatsState.value.copy(messages = newList)
                chatDao.run {
                    addMessageList(newList)
                }
            }.launchIn(viewModelScope)
    }

    fun sendMessage() {
        viewModelScope.launch(coroutineExceptionHandler) {
            if (messageText.value.isNotBlank()) {
                chatSocketService.sendMessage(messageText.value)
                _messageText.value = ""
            }
        }
    }


    fun onLastItem() {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = messageDataSource.getAllMessages(pageNumber).data ?: listOf()
            chatDao.addMessageList(res)
            _chatsState.run {
                value.messages += res
            }
        }
    }

    fun disconnect() {
        viewModelScope.launch(coroutineExceptionHandler) {
            chatSocketService.closeSession()
        }
    }

    override fun onCleared() {
        super.onCleared()

        pageNumber = 1

        disconnect()
    }
}

