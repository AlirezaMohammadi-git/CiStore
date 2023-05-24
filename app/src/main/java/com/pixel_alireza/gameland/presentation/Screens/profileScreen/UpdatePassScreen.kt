package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Change password") },
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
                                        "passwords not same",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    "password most be more than 8 character",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "please fill all fields",
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
                placeholder = { Text(text = "current password") },
                shape = MaterialTheme.shapes.large,
                label = { Text(text = "current password") },
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
                placeholder = { Text(text = "new password") },
                shape = MaterialTheme.shapes.large,
                label = { Text(text = "new password") },
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
                placeholder = { Text(text = "confirm new password") },
                shape = MaterialTheme.shapes.large,
                label = { Text(text = "confirm new password") },
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
                                    "passwords not same",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "password most be more than 8 character",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            context,
                            "please fill all fields",
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