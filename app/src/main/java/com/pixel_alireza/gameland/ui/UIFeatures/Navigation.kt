package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pixel_alireza.gameland.Screens.CartScreen.CartScreen
import com.pixel_alireza.gameland.Screens.Home.HomeScreen
import com.pixel_alireza.gameland.Screens.RoomScreen.RoomScreen
import com.pixel_alireza.gameland.Screens.SrearchScreen.SearchScreen
import com.pixel_alireza.gameland.Screens.addNewCustom.AddNewCustom
import com.pixel_alireza.gameland.Screens.globalChatScreen.GlobalChat
import com.pixel_alireza.gameland.Screens.globalScreen.GlobalScreen
import com.pixel_alireza.gameland.Screens.profileScreen.ProfileScreen
import com.pixel_alireza.gameland.Screens.settingsScreen.SettingsScreen
import com.pixel_alireza.gameland.utils.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier
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
            ProfileScreen()
        }
        composable(route = Screen.SearchScreen.rout) {
            SearchScreen()
        }
        composable(route = Screen.RoomScreen.rout) {
            RoomScreen()
        }
        composable(route = Screen.ChatScreen.rout) {
            GlobalChat()
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
    }
}