package com.pixel_alireza.gameland.data.local.model.cache

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object TokenInMemory {

     var token: String? = null

    fun refreshToken(token: String?) {
        this.token = token
    }
    fun getToken() : Flow<String?> {
        return flow { emit(token) }
    }


}