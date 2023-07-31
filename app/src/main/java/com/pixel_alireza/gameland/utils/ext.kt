package com.pixel_alireza.gameland.utils

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler


val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
    Log.e(TAG.Error.tag, "coroutineError: $throwable ")
}

class NoInternetException(message: String = "No Internet connection") : Exception(message)

sealed class TAG(val tag: String) {
    object Error : TAG("ERROR")
    object Info : TAG("INFO")
    object Warning : TAG("WARNING")
}


//fun userProf(userService: UserService) : String{
//    userService.loadFromSharePref()
//    return if (TokenInMemory.token == null) Screen.SignInScreen.rout else Screen.ProfileScreen.rout
//}


fun endPointChooser(gameTag: String): String {

    return when (gameTag) {
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


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++   stylePrice  ++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
fun stylePrice(price: String): String {
    return if (price.length > 3) {
        val reversedPrice = price.reversed()
        var newPrice = ""
        for (i in reversedPrice.indices) {
            if (i % 3 == 0) newPrice += ","
            newPrice += reversedPrice[i].toString()
        }
        if (newPrice.first() == ',') {
            newPrice = newPrice.substring(startIndex = 1)
        }
       newPrice.reversed()
    } else {
        price
    }
}



fun String.addCurrency() : String {
return "$currency $this"
}


fun String.addEndPoint(gameTag: String) : String {
    return "$this ${endPointChooser(gameTag)}"
}

fun amountLine(price: Int, count: Int, currency: String): String {
    val res = price * count
    return " : $res $currency"
}