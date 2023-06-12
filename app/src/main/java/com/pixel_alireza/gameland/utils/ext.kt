package com.pixel_alireza.gameland.utils

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler


val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
    Log.e(TAG.Error.tag, "coroutineError: $throwable ")
}


sealed class TAG(val tag: String) {
    object Error : TAG("ERROR")
    object Info : TAG("INFO")
    object Warning : TAG("WARNING")
}


//fun userProf(userService: UserService) : String{
//    userService.loadFromSharePref()
//    return if (TokenInMemory.token == null) Screen.SignInScreen.rout else Screen.ProfileScreen.rout
//}


fun endPointChooser(gamename: String): String {

    return when (gamename) {
        GameNames.CODM -> {
            "CP"
        }

        GameNames.ClashOfClans -> {
            "GEM"
        }

        GameNames.ClashRoyal -> {
            "GEM"
        }

        GameNames.PUBGMOBILE -> {
            "UC"
        }

        GameNames.FREEFIRE -> {
            "Coin"
        }

        else -> {
            ""
        }
    }

}