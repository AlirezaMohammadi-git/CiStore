package com.pixel_alireza.gameland.data.remote.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class SignInResponse(
    val res: Boolean,
    val token: String?,
    val message: String?
)