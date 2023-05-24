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