package com.pixel_alireza.gameland.data.remote.room

import kotlinx.serialization.Serializable


@Serializable
data class RoomInfo(
    val username: String,
    val email: String,
    val password: String
)
