package com.pixel_alireza.gameland.presentation.Screens.globalChatScreen

import android.content.Context
import android.util.Log
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.gameland.R
import com.pixel_alireza.gameland.data.local.model.cache.UsernameInMemory
import com.pixel_alireza.gameland.data.remote.model.chat.ChatState
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder
import com.pixel_alireza.gameland.ui.UIFeatures.MessageBoxItem
import com.pixel_alireza.gameland.utils.TAG
import com.pixel_alireza.gameland.utils.timeFormatter
import ir.dunijet.broadcastreceiver.NetworkChecker
import kotlinx.coroutines.flow.collectLatest

@Composable
fun GlobalChat(context: Context, viewModel: ChatViewModel = hiltViewModel()) {

    //toasting errors to user
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
                viewModel.connectSession(context)
                viewModel.socketStatus(context)
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
        val state = viewModel.getChatsState.value
        ChatScreen(
            viewModel = viewModel,
            savedUsername = UsernameInMemory.username!!,
            chatState = state
        )
    } else {
        NoUsernameScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(viewModel: ChatViewModel, savedUsername: String, chatState: ChatState) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (NetworkChecker(context).isInternetConnected) {
                            if (viewModel.socketStatus.value) stringResource(id = R.string.publicChat) else stringResource(
                                id = R.string.connecting
                            )
                        } else {
                            stringResource(id = R.string.whatingForNetwork)
                        },
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme
                        .colorScheme
                        .surfaceColorAtElevation(3.dp)
                )
            )
        }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {


            val scrollState = rememberLazyListState()
            val lastItem = remember { derivedStateOf { scrollState.layoutInfo.totalItemsCount } }
            LazyColumn(
                state = scrollState,
                modifier = Modifier.weight(1f),
                reverseLayout = true
            ) {
                items(count = chatState.messages.size) {
                    MessageBoxItem(
                        isOwnMessage = chatState.messages[it].username == savedUsername,
                        username = chatState.messages[it].username,
                        messageText = chatState.messages[it].text,
                        formattedTime = timeFormatter(chatState.messages[it].timestamp),
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            LaunchedEffect(scrollState) {
                snapshotFlow { scrollState.firstVisibleItemIndex }
                    .collect {
                        if (lastItem.value - 8 == it) {
                            viewModel.increasePage()
                            viewModel.getPreviousMessages()
                        }
                    }
            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            ) {
                TextField(
                    value = viewModel.messageText.value,
                    onValueChange = {
                        viewModel::onChangeMessage.invoke(it)
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.message))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(onClick = {
                            if (viewModel.messageText.value.length > 500) {
                                Toast.makeText(
                                    context,
                                    R.string.limitedCharacter,
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else viewModel.sendMessage()
                        }) {
                            Icon(Icons.Default.Send, "send")
                        }
                    }
                )
            }
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
                    value = "", onValueChange = {},
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
            Text(text = stringResource(id = R.string.pleaseLoginToUseGChat))
        }
    }
}
