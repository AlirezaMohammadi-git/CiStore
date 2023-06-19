package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameland.R
import com.pixel_alireza.gameland.presentation.Screens.SignIn.SignIn
import com.pixel_alireza.gameland.presentation.profileScreen.AddressField
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder
import com.pixel_alireza.gameland.utils.Screen
import com.pixel_alireza.gameland.utils.TAG


@Composable
fun ProfileScreen(
    navController: NavController ,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    viewModel.loadInfo()

    if (viewModel.isTokenNull()) {
        SignIn(
            viewModel = viewModel,
            context = context,
            onLoginClicked = { navController.navigate(Screen.ProfileScreen.rout) },
            onSignUpClicked = { navController.navigate(Screen.SignUpScreen.rout) },
            navigation = navController
        )
    }else {
        VerifiedScreen(viewModel = viewModel, onSignOutClick = {
            viewModel.signOut()
            navController.navigate(Screen.SignInScreen.rout) {
                popUpTo(Screen.HomeScreen.rout) {
                    inclusive = true
                }
            }
        }, onUsernameChange = {
            navController.navigate(Screen.EditUsername.rout)
        },
            onEditAvatar = {

            },
            onChangePasswordClicked = {
                navController.navigate(Screen.UpdatePass.rout)
            }
        )
    }
}


@Composable
fun VerifiedScreen(
    viewModel: ProfileScreenViewModel,
    onSignOutClick: () -> Unit,
    onEditAvatar: () -> Unit,
    onUsernameChange: () -> Unit,
    onChangePasswordClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                LottieAnimationBuilder(
                    modifier = Modifier.size(120.dp), animationAdress = R.raw.gradient
                )
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(80.dp)
                        .clip(shape = CircleShape)
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Column() {
                Box(
                ) {
                    AddressField(
                        value = viewModel.username.value,
                        onValueChange = { viewModel.username.value = it },
                        placeHolder = {
                            Text(text = stringResource(id = R.string.username))
                        },
                        enabled = false,
                        number = false
                    )
                    TextButton(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(bottom = 8.dp),
                        onClick = { onUsernameChange.invoke() }) {
                        Text(text = stringResource(id = R.string.edit))
                    }
                }

                AddressField(
                    value = viewModel.emailValue.value,
                    onValueChange = { },
                    placeHolder = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    enabled = false,
                    number = false
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(0.95f),
                    onClick = { onChangePasswordClicked.invoke() }) {
                    Text(text = stringResource(id = R.string.changePass))
                }
                Spacer(Modifier.height(16.dp))
                Button(modifier = Modifier.fillMaxWidth(0.95f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    onClick = {
                        onSignOutClick.invoke()
                    }) {
                    Text(text = stringResource(id = R.string.logOut))
                }
                LottieAnimationBuilder(
                    animationAdress = R.raw.pencil_drawing, modifier = Modifier.size(250.dp)
                )
            }
        }
    }
}


