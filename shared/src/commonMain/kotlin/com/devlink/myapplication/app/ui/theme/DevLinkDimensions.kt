package com.devlink.myapplication.app.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DevLinkDimensions(
    val default: Dp = 8.dp,
    val spaceSmall: Dp = 4.dp,
    val spaceMedium: Dp = 8.dp,
    val spaceLarge: Dp = 16.dp,
    val spaceExtraLarge: Dp = 32.dp,
    val spaceExtraNahuyLarge: Dp = 64.dp,
    val spaceExtraNahuyEptaLarge: Dp = 128.dp,
    val spaceExtraNahuyEptaEbatLarge: Dp = 256.dp,
    val belowExtra: Dp = 768.dp
)

val LocalDimensions = staticCompositionLocalOf { DevLinkDimensions() }