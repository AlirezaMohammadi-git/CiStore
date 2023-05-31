package com.pixel_alireza.gameland.utils

import android.util.Log
import com.pixel_alireza.gameland.data.local.model.cache.TokenInMemory
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject


val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
    Log.e(TAG.Error.tag, "coroutineError: $throwable ")
}


sealed class TAG(val tag: String) {
    object Error : TAG("ERROR")
    object Info : TAG("INFO")
    object Warning : TAG("WARNING")
}


fun userProf(userService: UserService) : String{
    userService.loadFromSharePref()
    return if (TokenInMemory.token == null) Screen.SignInScreen.rout else Screen.ProfileScreen.rout
}