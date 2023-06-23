package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
fun UpdatePasswordScreen(
    context: Context,
    navController: NavController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {

    val firstTextFieldFocus = remember { FocusRequester() }
    val secondTextFieldFocus = remember { FocusRequester() }
    val thirdTextFieldFocus = remember { FocusRequester() }
    var currentPassword = viewModel.currentPass
    var newPassword = viewModel.newPass
    var confirmNewPassword = viewModel.confirmNewPass



    LaunchedEffect(Unit) {
        firstTextFieldFocus.requestFocus()
    }

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.changePass)) },
                modifier = Modifier,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (
                            currentPassword.value.isNotBlank() &&
                            newPassword.value.isNotBlank() &&
                            confirmNewPassword.value.isNotBlank()
                        ) {
                            if (newPassword.value.length >= 8) {
                                if (newPassword.value == confirmNewPassword.value) {
                                    viewModel.updatePass {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                        if (it == "password updated") {
                                            navController.navigate(Screen.ProfileScreen.rout) {
                                                popUpTo(Screen.UpdatePass.rout) {
                                                    inclusive = true
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Toast.makeText(
                                        context,
                                        R.string.passNotSame,
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    R.string.passMostBe8,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                R.string.pleaseFillAll,
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

        if (loading.value){
            LoadingScreen()
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {


                OutlinedTextField(
                    value = currentPassword.value,
                    onValueChange = { currentPassword.value = it },
                    placeholder = { Text(text = stringResource(id = R.string.currentPass)) },
                    shape = MaterialTheme.shapes.large,
                    label = { Text(text = stringResource(id = R.string.currentPass) ) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        secondTextFieldFocus.requestFocus()
                    }),
                    modifier = Modifier.focusRequester(firstTextFieldFocus)
                )


                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = newPassword.value,
                    onValueChange = { newPassword.value = it },
                    placeholder = { Text(text = stringResource(id = R.string.newPass)) },
                    shape = MaterialTheme.shapes.large,
                    label = { Text(text = stringResource(id = R.string.newPass)) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        thirdTextFieldFocus.requestFocus()
                    }),
                    modifier = Modifier.focusRequester(secondTextFieldFocus)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = confirmNewPassword.value,
                    onValueChange = { confirmNewPassword.value = it },
                    placeholder = { Text(text = stringResource(id = R.string.confirmNewPass)) },
                    shape = MaterialTheme.shapes.large,
                    label = { Text(text = stringResource(id = R.string.confirmNewPass)) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        if (
                            currentPassword.value.isNotBlank() &&
                            newPassword.value.isNotBlank() &&
                            confirmNewPassword.value.isNotBlank()
                        ) {
                            if (newPassword.value.length >= 8) {
                                if (newPassword.value == confirmNewPassword.value) {
                                    viewModel.updatePass {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                        navController.navigate(Screen.ProfileScreen.rout) {
                                            popUpTo(Screen.UpdatePass.rout) {
                                                inclusive = true
                                            }
                                        }
                                    }
                                } else {
                                    Toast.makeText(
                                        context,
                                        R.string.passNotSame,
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    R.string.passMostBe8,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                R.string.pleaseFillAll,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }),
                    modifier = Modifier.focusRequester(thirdTextFieldFocus)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }


}