package com.pixel_alireza.gameland.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date


fun timeFormatter(time: Long): String {
    val simpleDateFormat = SimpleDateFormat("hh:mm:ss")
    val formattedTime = simpleDateFormat.format(Date(time))
    return formattedTime


//    val date = Date(time)
//    return DateFormat
//        .getDateInstance(DateFormat.DEFAULT)
//        .format(date)
}