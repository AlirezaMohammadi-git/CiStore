package com.pixel_alireza.gameland.data.remote.auth.model

import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    val res: Boolean,
    val message: String
)