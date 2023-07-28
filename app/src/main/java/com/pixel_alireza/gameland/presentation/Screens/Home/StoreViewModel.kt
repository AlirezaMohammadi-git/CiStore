package com.pixel_alireza.gameland.presentation.Screens.Home

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.local.ProductDatabase.ProductDao
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.data.remote.repo.store.StoreDataService
import com.pixel_alireza.gameland.utils.TAG
import com.pixel_alireza.gameland.utils.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.dunijet.broadcastreceiver.NetworkChecker
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val storeDataService: StoreDataService,
    private val productDao: ProductDao
) : ViewModel() {

    private val _items = mutableStateOf(listOf<StoreData>())
    val items: State<List<StoreData>> = _items

    private val _loading = MutableStateFlow(true)
    val loading : StateFlow<Boolean> = _loading

    suspend fun getItems(context: Context) {
        try {
            _loading.run {
                value = true
            }
            if (NetworkChecker(context).isInternetConnected) {
                viewModelScope.launch(coroutineExceptionHandler) {
                    val request = storeDataService.getAllItems()
                    when (request) {
                        is Resource.Error -> {
                            Log.i(TAG.Error.tag, "getItems: ${request.message}")
                            getItems(context)
                        }

                        is Resource.Success -> {
                            _items.value = request.data?.data ?: listOf()
                            productDao.deleteAllProducts()
                            productDao.addProductList(_items.value)
                            delay(1000)
                            _loading.run {
                                value = false
                            }
                        }
                    }

                }
            } else {
                viewModelScope.launch(coroutineExceptionHandler) {
                    _items.value = productDao.getAllItems()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun onEachBannerCardClicked( bannerURL : String ){
        //todo
    }
}