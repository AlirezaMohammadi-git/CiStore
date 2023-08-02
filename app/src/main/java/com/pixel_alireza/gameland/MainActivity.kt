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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gameland.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pixel_alireza.gameland.data.local.model.UIFeatures.BottomNavItem
import com.pixel_alireza.gameland.data.remote.repo.chat.socket.ChatSocketService
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
import com.pixel_alireza.gameland.ui.UIFeatures.MyBottomNavigation
import com.pixel_alireza.gameland.ui.UIFeatures.MyTopAppBar
import com.pixel_alireza.gameland.ui.UIFeatures.Navigation
import com.pixel_alireza.gameland.ui.theme.GameLandTheme
import com.pixel_alireza.gameland.utils.Screen
import com.pixel_alireza.gameland.utils.TAG
import com.pixel_alireza.gameland.utils.coroutineExceptionHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var chatSocketService: ChatSocketService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            GameLandTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
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
                                            "Search",
                                            Screen.SearchScreen.rout,
                                            Icons.Filled.Search ,
                                            Icons.Outlined.Search ,
                                        ),
                                        BottomNavItem(
                                            "CartScreen",
                                            Screen.CartScreen.rout,
                                            Icons.Filled.ShoppingCart ,
                                            Icons.Outlined.ShoppingCart ,
                                        ),
                                        BottomNavItem(
                                            "Profile",
                                            Screen.ProfileScreen.rout,
                                            Icons.Filled.Person,
                                            Icons.Outlined.Person,
                                        ),

                                        ),
                                    navController = navController,
                                    onItemClicked = { item ->
                                        if (item.rout != backStackEntry.value?.destination?.route) navController.navigate(
                                            item.rout
                                        )
                                    },
                                )
                            },
                            topBar = {
                                MyTopAppBar(
                                    title = stringResource(id = R.string.app_name),
                                    firstIcon = Pair(first = true, second = Icons.Default.ShoppingCart),
                                    secondIcon = Pair(first = true, second = Icons.Default.Settings),
                                    show = backStackEntry.value?.destination?.route == Screen.HomeScreen.rout,
                                )
                            }
                        ) {
                            Navigation(
                                navController = navController,
                                modifier = Modifier
                                    .padding(it),
                            )
                        }
                    }
                }
            }
        }
    }


    override fun onStart() {
        super.onStart()
        userService.loadFromSharePref()
    }


    override fun onStop() {
        super.onStop()
        lifecycleScope.launch(coroutineExceptionHandler) {
            chatSocketService.closeSession()
            Log.i(TAG.Info.tag, "onDestroy: session closed!")
        }
    }

}





