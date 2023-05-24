package com.pixel_alireza.gameland.data.local.model.cache

object TokenInMemory {

    var token: String? = null
        private set


    fun refreshToken(token: String?) {
        this.token = token
    }


}