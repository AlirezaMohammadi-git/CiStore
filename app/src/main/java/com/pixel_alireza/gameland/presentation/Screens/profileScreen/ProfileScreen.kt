package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameland.R
import com.pixel_alireza.gameland.data.remote.repo.user.UserServiceImpl
import com.pixel_alireza.gameland.presentation.Screens.SignIn.SignIn
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont
import com.pixel_alireza.gameland.utils.Screen
import io.ktor.client.HttpClient


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
    onUsernameChange: () -> Unit,
    onChangePasswordClicked: () -> Unit
) {

    Column {
        Surface(
            modifier = Modifier.fillMaxWidth()
                .requiredHeight(150.dp),
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = viewModel.getUsername(),
                    fontFamily = yekanBakhFont,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = viewModel.emailValue.value,
                    fontFamily = yekanBakhFont,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )

            }

        }

        LazyColumn {
            item {
                Card(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Column {
                        ProfileItems(
                            itemText = stringResource(R.string.productsSetuation),
                            icon = R.drawable.baseline_shopping_bag_24
                        ) {
                            //todo : implement this feature
                            println("this is just a test")
                        }
                        ProfileItems(
                            itemText = stringResource(R.string.changeUsername),
                            icon = R.drawable.baseline_person_24
                        ) {
                            onUsernameChange.invoke()
                        }
                        ProfileItems(
                            itemText = stringResource(R.string.changePass),
                            icon = R.drawable.baseline_lock_24
                        ) {
                            onChangePasswordClicked.invoke()
                        }
                        ProfileItems(
                            itemText = stringResource(R.string.contactWithSupport),
                            icon = R.drawable.baseline_support_agent_24
                        ) {
                            //todo : implement this feature
                        }
                        ProfileItems(
                            itemText = stringResource(R.string.rules),
                            icon = R.drawable.baseline_rule_24
                        ) {
                            //todo : implement this feature
                        }
                        ProfileItems(
                            itemText = stringResource(R.string.aboutUS),
                            icon = R.drawable.baseline_info_24
                        ) {
                            //todo : implement this feature
                        }
                        ProfileItems(
                            itemText = stringResource(R.string.logOut),
                            icon = R.drawable.baseline_logout_24,
                            lastItem = true
                        ) {
                            onSignOutClick.invoke()
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

    }

}


@Composable
@Preview
fun ToShowPreview(

) {
    val client = HttpClient()
    val viewModel = ProfileScreenViewModel(
        UserServiceImpl(
            client,
            LocalContext.current.getSharedPreferences("hello", Context.MODE_PRIVATE)
        )
    )

    VerifiedScreen(
        viewModel,
        {},
        {},
        {},
    )
}


