package com.pixel_alireza.gameland.data.remote.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class UpdateUsername(
    val username: String,
    val email: String
)