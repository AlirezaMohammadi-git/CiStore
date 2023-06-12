package com.pixel_alireza.gameland.data.remote.model

import kotlinx.serialization.Serializable


@Serializable
data class Common<T>(
    val res: Boolean,
    val message: String? = null,
    val data: T? = null
)
