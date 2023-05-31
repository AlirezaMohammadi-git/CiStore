package com.pixel_alireza.gameland

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pixel_alireza.gameland.data.local.model.UIFeatures.BottomNavItem
import com.pixel_alireza.gameland.data.local.model.cache.TokenInMemory
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
import com.pixel_alireza.gameland.ui.UIFeatures.MyBottomNavigation
import com.pixel_alireza.gameland.ui.UIFeatures.MyTopAppBar
import com.pixel_alireza.gameland.ui.UIFeatures.Navigation
import com.pixel_alireza.gameland.ui.theme.GameLandTheme
import com.pixel_alireza.gameland.utils.Screen
import com.pixel_alireza.gameland.utils.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameLandTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
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
                    val navController = rememberNavController()
                    val backStackEntry = navController.currentBackStackEntryAsState()
                    Scaffold(
                        bottomBar = {
                            MyBottomNavigation(
                                items = listOf(
                                    BottomNavItem(
                                        "Home",
                                        Screen.HomeScreen.rout,
                                        Icons.Filled.Home,
                                        Icons.Outlined.Home,
                                    ),
                                    BottomNavItem(
                                        "Rooms",
                                        Screen.GlobalScreen.rout,
                                        Icons.Filled.List,
                                        Icons.Outlined.List,
                                        2
                                    ),
                                    BottomNavItem(
                                        "Chat",
                                        Screen.ChatScreen.rout,
                                        Icons.Filled.Email,
                                        Icons.Outlined.Email,
                                    ),
                                    BottomNavItem(
                                        "Profile",
                                        Screen.ProfileScreen.rout,
                                        Icons.Filled.Person,
                                        Icons.Outlined.Person,
                                    ),
                                ),
                                navController = navController,
                                onItemClicked = { navController.navigate(it.rout) },
                            )
                        },
                        topBar = {
                            MyTopAppBar(
                                title = "Store",
                                firstIcon = Pair(first = true, second = Icons.Default.ShoppingCart),
                                secondIcon = Pair(first = true, second = Icons.Default.Settings),
                                show = backStackEntry.value?.destination?.route == Screen.HomeScreen.rout,
                                onFirstIconClicked = { navController.navigate(Screen.CartScreen.rout) },
                                onSecondIconClicked = { navController.navigate(Screen.SettingsScreen.rout) },
                            )
                        },
                        content = { innerPadding ->
                            Navigation(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding),
                                context = this,
                                myApp()
                            )
                        },
                    )
                }
            }
        }
    }
}





