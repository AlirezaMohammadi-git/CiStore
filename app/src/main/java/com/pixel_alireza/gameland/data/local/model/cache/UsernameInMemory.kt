package com.pixel_alireza.gameland.data.local.model.cache

object UsernameInMemory {
    var username: String? = null
        private set


    fun refreshUsername(username: String?) {
        this.username = username
    }

}