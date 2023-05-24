package com.pixel_alireza.gameland.presentation.Screens.globalChatScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.gameland.R
import com.pixel_alireza.gameland.data.local.model.cache.UsernameInMemory
import com.pixel_alireza.gameland.data.remote.chat.ChatState
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder
import com.pixel_alireza.gameland.ui.UIFeatures.MessageBoxItem
import com.pixel_alireza.gameland.utils.timeFormatter
import kotlinx.coroutines.flow.collectLatest


@Composable
fun GlobalChat(context: Context, viewModel: ChatViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true) {
        viewModel.toastEvent.collectLatest { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    //initializing connect and disconnect with parent lifecycle
    val lifeCycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifeCycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                viewModel.connectSession()
            } else if (event == Lifecycle.Event.ON_STOP) {
                viewModel.disconnect()
            }
        }
        lifeCycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }
    if (UsernameInMemory.username != null) {
        ChatScreen(
            viewModel = viewModel,
            savedUsername = UsernameInMemory.username!!,
            chatState = viewModel.getChatsState.value
        )
    } else {
        NoUsernameScreen()
    }
}

@Composable
fun ChatScreen(viewModel: ChatViewModel, savedUsername: String, chatState: ChatState) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = true
        ) {
            items(chatState.messages.size) {
                MessageBoxItem(
                    isOwnMessage = chatState.messages[it].username == savedUsername,
                    username = chatState.messages[it].username,
                    messageText = chatState.messages[it].text,
                    formattedTime = timeFormatter(chatState.messages[it].timestamp),
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 4.dp, bottom = 4.dp)
        ) {
            OutlinedTextField(
                value = viewModel.messageText.value, onValueChange = {
                    viewModel::onChangeMessage.invoke(it)
                },
                shape = MaterialTheme.shapes.large,
                placeholder = {
                    Text(text = "Message...")
                },
                modifier = Modifier.weight(1f),
                trailingIcon = {
                    IconButton(onClick = viewModel::sendMessage) {
                        Icon(Icons.Default.Send, "send")
                    }
                }
            )
        }
    }
}


@Composable
fun NoChatScreen(viewModel: ChatViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            LottieAnimationBuilder(
                animationAdress = R.raw.newsletter,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = "No Message")
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            ) {
                OutlinedTextField(
                    value = viewModel.messageText.value, onValueChange = {
                        viewModel::onChangeMessage.invoke(it)
                    },
                    placeholder = {
                        Text(text = "Message...")
                    },
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = viewModel::sendMessage) {
                    Icon(Icons.Default.Send, "send")
                }
            }
        }
    }
}

@Composable
fun NoUsernameScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            LottieAnimationBuilder(
                animationAdress = R.raw.shapes_balance_lottie_animation,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = "Please Login to join global chat!")
        }
    }
}
