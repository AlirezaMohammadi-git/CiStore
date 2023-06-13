package com.pixel_alireza.gameland.presentation.Screens.ProductScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixel_alireza.gameland.data.local.ProductDatabase.ProductDao
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.utils.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel
@Inject constructor(
    private val productDao: ProductDao
) : ViewModel() {

    private val _storeData = mutableStateOf(StoreData("", -1, -1, "", -1, "" , 1))
    val storeData: State<StoreData> = _storeData

    private val _email = mutableStateOf("")
    val email: State<String> = _email
    fun onChangeEmail(newChar: String) {
        _email.value = newChar
    }

    private val _gamePass = mutableStateOf("")
    val gamePass: State<String> = _gamePass
    fun onGamePassChange(newChar: String) {
        _gamePass.value = newChar
    }

    private val _gameName = mutableStateOf("")
    val gameName: State<String> = _gameName
    fun onGameNameChange(newChar: String) {
        _gameName.value = newChar
    }

    private val _productCount = mutableStateOf(1)
    val productCount: State<Int> = _productCount


    fun loadData(id: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            _storeData.value = productDao.getProductById(id)
        }
    }

    fun onRemoveProduct() {
        if (productCount.value != 1){
            val newValue = _productCount.value - 1
            _productCount.run {
                value = newValue
            }
        }

    }

    fun onAddMoreProduct() {
        val newValue = _productCount.value + 1
        _productCount.run {
            value = newValue
        }
    }

}