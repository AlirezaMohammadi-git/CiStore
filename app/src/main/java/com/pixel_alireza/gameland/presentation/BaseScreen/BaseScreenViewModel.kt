package com.pixel_alireza.gameland.presentation.BaseScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BaseScreenViewModel @Inject constructor() : ViewModel() {

    var selectedItem = mutableStateOf(0)
    val items = listOf("Home", "Rooms", "Profile")

}