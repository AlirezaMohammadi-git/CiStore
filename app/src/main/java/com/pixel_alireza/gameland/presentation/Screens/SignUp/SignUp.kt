package com.pixel_alireza.gameland.presentation.Screens.SignUp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameland.R
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreenViewModel
import com.pixel_alireza.gameland.presentation.profileScreen.EmailField
import com.pixel_alireza.gameland.presentation.profileScreen.PasswordField
import com.pixel_alireza.gameland.presentation.profileScreen.UsernameField
import com.pixel_alireza.gameland.ui.UIFeatures.LoadingScreen
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont


@Composable
fun SignUp(
    viewModel: ProfileScreenViewModel, context: Context, onLogInClicked: () -> Unit,
    onSignUpClicked: () -> Unit
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

    if (loading.value) {
        LoadingScreen()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 32.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.signUp), fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            UsernameField(
                value = viewModel.username.value,
                onValueChange = { viewModel.username.value = it },
                placeHolder = { Text(text = stringResource(id = R.string.username)) },
                enabled = true
            )
            EmailField(
                value = viewModel.emailValue.value,
                onValueChange = { viewModel.emailValue.value = it },
                placeHolder = { Text(text = stringResource(id = R.string.email)) },
                enabled = true,
                isError = true
            )
            val passVisibility = remember {
                mutableStateOf(false)
            }
            PasswordField(
                value = viewModel.passwordValue.value,
                onValueChange = { viewModel.passwordValue.value = it },
                placeHolder = { Text(text = stringResource(id = R.string.password)) },
                enabled = true,
                SupportText = {
                    if (viewModel.passwordValue.value.isNotBlank()) Text(
                        text = stringResource(
                            id = R.string.passMostBe8
                        )
                    )
                },
                EmptySupportText = {},
                passChar = 8,
                isFocused = remember {
                    mutableStateOf(false)
                },
                leadingIC = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                trailingIC = {
                    val image =
                        if (passVisibility.value) R.drawable.ic_visible_eye else R.drawable.ic_eye_invisible
                    Icon(painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            passVisibility.value = !passVisibility.value
                        })
                },
                visualTransformation = if (passVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
            )
            val confPassVisibility = remember {
                mutableStateOf(false)
            }
            PasswordField(
                value = viewModel.confPasswordValue.value,
                onValueChange = { viewModel.confPasswordValue.value = it },
                placeHolder = { Text(text = stringResource(id = R.string.confirmPass)) },
                enabled = true,
                SupportText = { },
                EmptySupportText = {},
                passChar = 8,
                isFocused = remember {
                    mutableStateOf(false)
                },
                leadingIC = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                trailingIC = {
                    val image =
                        if (confPassVisibility.value) R.drawable.ic_visible_eye else R.drawable.ic_eye_invisible
                    Icon(painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            confPassVisibility.value = !confPassVisibility.value
                        })
                },
                visualTransformation = if (confPassVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
            )
            Button(
                onClick = {
                    //on Sign Up Clicked

                    val username = viewModel.username.value
                    val email = viewModel.emailValue.value
                    val password = viewModel.passwordValue.value
                    val confPass = viewModel.confPasswordValue.value

                    if (username.isBlank()) {
                        Toast.makeText(context, R.string.pleaseUsername, Toast.LENGTH_SHORT).show()
                    } else if (email.isBlank()) {
                        Toast.makeText(context, R.string.pleaseEmail, Toast.LENGTH_SHORT).show()
                    } else if (password.isBlank()) {
                        Toast.makeText(context, R.string.pleasePass, Toast.LENGTH_SHORT).show()
                    } else if (confPass.isBlank()) {
                        Toast.makeText(context, R.string.pleaseConfPass, Toast.LENGTH_SHORT).show()
                    } else if (username.length > 16 || username.length < 2) {
                        Toast.makeText(context, R.string.usernameLength, Toast.LENGTH_SHORT).show()
                    } else if (password.length < 8) {
                        Toast.makeText(
                            context,
                            R.string.passMostBe8,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (password != confPass) {
                        Toast.makeText(context, R.string.passNotSame, Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.signUp {
                            if (it) {
                                onSignUpClicked.invoke()
                            }
                        }
                    }

                }, modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(R.string.signUp), fontFamily = yekanBakhFont)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 32.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.alreadyHaveAcc),
                    fontWeight = FontWeight.Light
                )
                TextButton(onClick = {
                    onLogInClicked.invoke()
                }) {
                    Text(text = stringResource(id = R.string.login))
                }
            }
        }
    }
}