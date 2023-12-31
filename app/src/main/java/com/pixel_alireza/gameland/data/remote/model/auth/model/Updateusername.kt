package com.pixel_alireza.gameland.data.remote.model.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class UpdateUsername(
    val username: String,
    val email: String
)