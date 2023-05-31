package com.pixel_alireza.gameland.ui.UIFeatures

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pixel_alireza.gameland.presentation.Screens.CartScreen.CartScreen
import com.pixel_alireza.gameland.presentation.Screens.Home.HomeScreen
import com.pixel_alireza.gameland.presentation.Screens.RoomScreen.RoomScreen
import com.pixel_alireza.gameland.presentation.Screens.SignIn.SignIn
import com.pixel_alireza.gameland.presentation.Screens.SignUp.SignUp
import com.pixel_alireza.gameland.presentation.Screens.SrearchScreen.SearchScreen
import com.pixel_alireza.gameland.presentation.Screens.addNewCustom.AddNewCustom
import com.pixel_alireza.gameland.presentation.Screens.globalChatScreen.GlobalChat
import com.pixel_alireza.gameland.presentation.Screens.globalScreen.GlobalScreen
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ChangeUsername
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreen
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.ProfileScreenViewModel
import com.pixel_alireza.gameland.presentation.Screens.profileScreen.UpdatePasswordScreen
import com.pixel_alireza.gameland.presentation.Screens.settingsScreen.SettingsScreen
import com.pixel_alireza.gameland.utils.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier,
    context: Context,
    application: Application
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.rout,
        modifier = modifier
    ) {
        composable(route = Screen.HomeScreen.rout) {
            HomeScreen()
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
        composable(route = Screen.RoomScreen.rout) {
            RoomScreen()
        }
        composable(route = Screen.ChatScreen.rout) {
            GlobalChat(context = context)
        }
        composable(route = Screen.CartScreen.rout) {
            CartScreen()
        }
        composable(route = Screen.SettingsScreen.rout) {
            SettingsScreen()
        }
        composable(route = Screen.AddNewCustomScreen.rout) {
            AddNewCustom()
        }
        composable(route = Screen.SignInScreen.rout) {
            SignIn(viewModel = hiltViewModel(), context = context,
                onLoginClicked = {
                    navController.navigate(Screen.ProfileScreen.rout)
                }) {
                navController.navigate(Screen.SignUpScreen.rout)
            }
        }
        composable(route = Screen.SignUpScreen.rout) {
            SignUp(viewModel = hiltViewModel<ProfileScreenViewModel>(), context = context,
                onSignUpClicked = {
                    navController.navigate(Screen.ProfileScreen.rout) {
                        popUpTo(Screen.SignUpScreen.rout) {
                            inclusive = true
                        }
                    }
                }, onLogInClicked = {
                    navController.navigate(Screen.SignInScreen.rout)
                })
        }
        composable(route = Screen.EditUsername.rout) {
            ChangeUsername(context = context, navController = navController)
        }
        composable(route = Screen.UpdatePass.rout) {
            UpdatePasswordScreen(context = context, navController = navController)
        }
    }
}