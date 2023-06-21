package com.pixel_alireza.gameland.presentation.Screens.SignIn

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import com.example.gameland.R
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreenViewModel
import com.pixel_alireza.gameland.presentation.profileScreen.EmailField
import com.pixel_alireza.gameland.presentation.profileScreen.PasswordField
import com.pixel_alireza.gameland.ui.UIFeatures.LoadingScreen
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder
import kotlinx.coroutines.flow.collectLatest


@Composable
fun SignIn(
    viewModel: ProfileScreenViewModel,
    context: Context,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    navigation: NavController
) {


    val loading = remember {
        mutableStateOf(false)
    }

    //toasting errors to user
    LaunchedEffect(key1 = true) {
        viewModel.toastEvent.collectLatest { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
    LaunchedEffect(key1 = true) {
        viewModel.loading.collect {
            loading.value = it
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
                    text = stringResource(id = R.string.signIn),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            EmailField(
                value = viewModel.emailValue.value,
                onValueChange = { viewModel.emailValue.value = it },
                placeHolder = { Text(text = stringResource(id = R.string.email)) },
                enabled = true,
                isError = true
            )

            Spacer(modifier = Modifier.height(16.dp))

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


            Button(
                onClick = {

                    //On Sign In clicked

                    val email = viewModel.emailValue.value
                    val pass = viewModel.passwordValue.value

                    if (email.isBlank()) {
                        Toast.makeText(context, R.string.pleaseEmail, Toast.LENGTH_SHORT).show()
                    } else if (pass.isBlank()) {
                        Toast.makeText(context, R.string.pleasePass, Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.signIn {
                            if (it) {
                                onLoginClicked.invoke()
                            }
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.login))
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 32.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.dontHaveAcc),
                    fontWeight = FontWeight.Light
                )
                TextButton(onClick = { onSignUpClicked.invoke() }) {
                    Text(
                        text = stringResource(id = R.string.signUp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

            }

        }
    }
}