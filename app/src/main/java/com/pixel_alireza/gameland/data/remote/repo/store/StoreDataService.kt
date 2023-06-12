package com.pixel_alireza.gameland.data.remote.repo.store

import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.model.Common
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.utils.Constants

interface StoreDataService {
    suspend fun getAllItems() : Resource<Common<List<StoreData>>>
    sealed class endPoint (val url:String){
        object getAllItemds : endPoint("${Constants.NORMAL_BASE_URL}/getStoreItems")
    }
}