package com.pixel_alireza.gameland.presentation.Screens.SrearchScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _searchValue = mutableStateOf("")
    val searchValue : State<String> = _searchValue

    fun changSearchValue(newValue : String){
        _searchValue.value = newValue
    }

}