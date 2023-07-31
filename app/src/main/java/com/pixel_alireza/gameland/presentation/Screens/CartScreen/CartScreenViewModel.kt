package com.pixel_alireza.gameland.presentation.Screens.CartScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class CartScreenViewModel @Inject constructor() : ViewModel() {

    private val _totalCount = mutableStateOf(5)
    val totalCount: State<Int> = _totalCount

}