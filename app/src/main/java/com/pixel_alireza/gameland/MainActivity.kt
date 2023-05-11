package com.pixel_alireza.gameland

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pixel_alireza.gameland.Screens.BaseScreen.BaseScreen
import com.pixel_alireza.gameland.Screens.Home.HomeScreen
import com.pixel_alireza.gameland.Screens.RoomScreen.RoomScreen
import com.pixel_alireza.gameland.Screens.SrearchScreen.SearchScreen
import com.pixel_alireza.gameland.Screens.globalScreen.GlobalScreen
import com.pixel_alireza.gameland.Screens.profileScreen.ProfileScreen
import com.pixel_alireza.gameland.ui.theme.GameLandTheme
import com.pixel_alireza.gameland.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameLandTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //<editor-fold desc="Some Settings">
                    val systemUiController = rememberSystemUiController()
                    systemUiController.setStatusBarColor(
                        color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp), //Your color
                    )
                    systemUiController.setNavigationBarColor(
                        color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp), //Your color
                    )
                    //</editor-fold>
                    val ScreenIndex = remember { mutableStateOf(0) }
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.rout
                    ) {

                        composable(route = Screen.HomeScreen.rout) {
                            HomeScreen()
                        }

                        composable(route = Screen.GlobalScreen.rout) {
                            GlobalScreen ( onSearchBarClicked = {
                                navController.navigate(Screen.SearchScreen.rout)
                            } ) {
                                navController.navigate(Screen.RoomScreen.rout)
                            }
                        }
                        composable(route = Screen.ProfileScreen.rout) {
                            ProfileScreen()
                        }
                        composable(route = Screen.SearchScreen.rout){
                            SearchScreen()
                        }
                        composable(route = Screen.RoomScreen.rout){
                            RoomScreen()
                        }

                    }
                    BaseScreen { index ->

                        when (index){
                            0 -> {navController.navigate(Screen.HomeScreen.rout)}
                            1 -> {navController.navigate(Screen.GlobalScreen.rout)}
                            2 -> {navController.navigate(Screen.ProfileScreen.rout)}
                        }

                        ScreenIndex.value = index
                    }
                }
            }
        }
    }
}





