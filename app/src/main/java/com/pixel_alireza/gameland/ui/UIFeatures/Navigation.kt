package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pixel_alireza.gameland.presentation.Screens.CartScreen.CartScreen
import com.pixel_alireza.gameland.presentation.Screens.CustomRoomScreen.GlobalScreen
import com.pixel_alireza.gameland.presentation.Screens.Home.StoreScreen
import com.pixel_alireza.gameland.presentation.Screens.ProductScreen.ProductScreen
import com.pixel_alireza.gameland.presentation.Screens.SignIn.SignIn
import com.pixel_alireza.gameland.presentation.Screens.SignUp.SignUp
import com.pixel_alireza.gameland.presentation.Screens.SrearchScreen.SearchScreen
import com.pixel_alireza.gameland.presentation.Screens.globalChatScreen.GlobalChat
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ChangeUsername
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreen
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreenViewModel
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.UpdatePasswordScreen
import com.pixel_alireza.gameland.presentation.Screens.settingsScreen.SettingsScreen
import com.pixel_alireza.gameland.utils.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    val context = LocalContext.current

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.HomeScreen.rout,
    ) {
        composable(route = Screen.HomeScreen.rout) {
            StoreScreen { id ->
                navController.navigate("${Screen.ProductScreen.rout}/$id")
            }
        }
        composable(route = Screen.GlobalScreen.rout) {
            GlobalScreen(
                onSearchBarClicked = {
                    navController.navigate(Screen.SearchScreen.rout)
                },
                onAddCustomClicked = {
                    navController.navigate(Screen.AddNewCustomScreen.rout)
                }
            ) {
                navController.navigate(Screen.RoomScreen.rout)
            }
        }
        composable(route = Screen.ProfileScreen.rout) {
            ProfileScreen(navController)
        }
        composable(route = Screen.SearchScreen.rout) {
            SearchScreen()
        }
        composable(route = Screen.ChatScreen.rout) {
            GlobalChat(context)
        }
        composable(route = Screen.CartScreen.rout) {
            CartScreen()
        }
        composable(route = Screen.SettingsScreen.rout) {
            SettingsScreen()
        }
        composable(route = Screen.SignInScreen.rout) {
            SignIn(
                viewModel = hiltViewModel(),
                context = context,
                onLoginClicked = {
                    navController.navigate(Screen.ProfileScreen.rout)
                },
                navigation = navController,
                onSignUpClicked = {
                    navController.navigate(Screen.SignUpScreen.rout)
                }
            )
        }
        composable(route = Screen.SignUpScreen.rout) {
            SignUp(
                viewModel = hiltViewModel<ProfileScreenViewModel>(),
                context = context,
                onSignUpClicked = {
                    navController.navigate(Screen.ProfileScreen.rout) {
                        popUpTo(Screen.SignUpScreen.rout) {
                            inclusive = true
                        }
                    }
                },
                onLogInClicked = {
                    navController.navigate(Screen.SignInScreen.rout)
                },
            )
        }
        composable(route = Screen.EditUsername.rout) {
            ChangeUsername(context = context, navController = navController)
        }
        composable(route = Screen.UpdatePass.rout) {
            UpdatePasswordScreen(context = context, navController = navController)
        }
        composable(
            route = "${Screen.ProductScreen.rout}/{my_param}",
            arguments = listOf(
                navArgument("my_param") {
                    type = NavType.StringType
                }
            )) {
            val id = it.arguments?.getString("my_param") ?: ""
            ProductScreen(id = id)
        }
    }
}