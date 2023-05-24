package com.pixel_alireza.gameland.data.remote.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class SecretInfo(
    val userId: String? = null,
    val username: String,
    val email: String? = null
)