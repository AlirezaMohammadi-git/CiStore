package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameland.R
import com.pixel_alireza.gameland.ui.UIFeatures.LoadingScreen
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder
import com.pixel_alireza.gameland.utils.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeUsername(
    viewModel: ProfileScreenViewModel = hiltViewModel<ProfileScreenViewModel>(),
    context: Context,
    navController: NavController,
) {

    val username = remember {
        mutableStateOf(viewModel.getUsername())
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.changeUsername)) },
                modifier = Modifier,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (username.value.length < 16 && username.value.isNotBlank()) {
                            viewModel.updateUsername(username.value) { res, message ->
                                if (res) {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                    navController.navigate(Screen.ProfileScreen.rout) {
                                        popUpTo(Screen.EditUsername.rout) {
                                            inclusive = true
                                        }
                                    }
                                } else {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                    navController.navigate(Screen.SignInScreen.rout) {
                                        popUpTo(Screen.EditUsername.rout) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                        } else {
                            Toast.makeText(
                                context,
                                R.string.usernameLength,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }) {
                        Icon(Icons.Default.Done, null)
                    }
                }
            )
        }
    ) {

        val loading = remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = true) {
            viewModel.toastEvent.collect {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }

        LaunchedEffect(key1 = true) {
            viewModel.loading.collect {
                viewModel.loading.collect {
                    loading.value = it
                }
            }
        }


        if (loading.value){
            LoadingScreen()
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val focusReq = remember { FocusRequester() }
                    OutlinedTextField(
                        value = username.value,
                        onValueChange = { it -> username.value = it },
                        modifier = Modifier
                            .focusRequester(focusReq)
                            .align(Alignment.CenterVertically),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            if (username.value.length < 16 && username.value.isNotBlank()) {
                                viewModel.updateUsername(username.value) { res, message ->
                                    if (res) {
                                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                        navController.navigate(Screen.ProfileScreen.rout) {
                                            popUpTo(Screen.EditUsername.rout) {
                                                inclusive = true
                                            }
                                        }
                                    } else {
                                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                        navController.navigate(Screen.SignInScreen.rout) {
                                            popUpTo(Screen.EditUsername.rout) {
                                                inclusive = true
                                            }
                                        }
                                    }
                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    R.string.usernameLength,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                    )

                    LaunchedEffect(Unit) {
                        focusReq.requestFocus()
                    }
                }


//            Button(onClick = {
//                if (viewModel.username.value.isNotBlank()) {
//
//                }
//            }) {
//                Text(text = "change")
//            }

            }
        }
    }
}