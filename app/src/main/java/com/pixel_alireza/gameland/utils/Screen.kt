package com.pixel_alireza.gameland.utils

sealed class Screen (val rout : String) {
    object GlobalScreen : Screen("globalScreen")
    object ProfileScreen : Screen("ProfileScreen")
    object HomeScreen : Screen("HomeScreen")
    object SearchScreen : Screen("SearchScreen")
    object RoomScreen : Screen("RoomScreen")
}