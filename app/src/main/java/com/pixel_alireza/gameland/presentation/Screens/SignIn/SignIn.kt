package com.pixel_alireza.gameland.presentation.Screens.SignIn

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gameland.R
import com.pixel_alireza.gameland.data.local.model.cache.TokenInMemory
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreenViewModel
import com.pixel_alireza.gameland.presentation.profileScreen.EmailField
import com.pixel_alireza.gameland.presentation.profileScreen.PasswordField
import com.pixel_alireza.gameland.utils.Screen
import com.pixel_alireza.gameland.utils.TAG


@Composable
fun SignIn(
    viewModel: ProfileScreenViewModel,
    context: Context,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    navigation : NavController
) {


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
                text = "Sign In",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }
        EmailField(
            value = viewModel.emailValue.value,
            onValueChange = { viewModel.emailValue.value = it },
            placeHolder = { Text(text = "Email") },
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
            placeHolder = { Text(text = "password") },
            enabled = true,
            SupportText = { if (viewModel.passwordValue.value.isNotBlank()) Text(text = "password most be more than 8 character") },
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
                    modifier = Modifier.clickable { passVisibility.value = !passVisibility.value })
            },
            visualTransformation = if (passVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
        )


        Button(
            onClick = {

                //On Sign In clicked

                val email = viewModel.emailValue.value
                val pass = viewModel.passwordValue.value

                if (email.isBlank()) {
                    Toast.makeText(context, "please enter email", Toast.LENGTH_SHORT).show()
                } else if (pass.isBlank()) {
                    Toast.makeText(context, "please enter password", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.signIn {
                        if (it) {
                            onLoginClicked.invoke()
                        } else {
                            Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }, modifier = Modifier
                .fillMaxWidth(0.5f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Login")
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, bottom = 32.dp)
        ) {

            Text(text = "Don't have an account?", fontWeight = FontWeight.Light)
            TextButton(onClick = { onSignUpClicked.invoke() }) {
                Text(text = "Sign Up", color = MaterialTheme.colorScheme.primary)
            }

        }

    }
}