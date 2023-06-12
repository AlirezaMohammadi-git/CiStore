package com.pixel_alireza.gameland.data.remote.model.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class authRequest(
    val username: String? = null,
    val email: String,
    val password: String
)
