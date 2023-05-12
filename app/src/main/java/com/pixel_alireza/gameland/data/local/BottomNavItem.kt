package com.pixel_alireza.gameland.data.local

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val rout: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector,
    val badgeCount: Int = 0
)
