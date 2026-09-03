package com.devlink.myapplication.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.devlink.myapplication.app.ui.theme.colors.DarkBackground
import com.devlink.myapplication.app.ui.theme.colors.DarkThemeText
import com.devlink.myapplication.app.ui.theme.colors.LightBackground
import com.devlink.myapplication.app.ui.theme.colors.LightThemeText

private val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    onBackground = DarkThemeText
)

private val LightColorScheme = lightColorScheme(
    background = LightBackground,
    onBackground = LightThemeText
)

val MaterialTheme.dimens: DevLinkDimensions
@Composable
@ReadOnlyComposable
get() = LocalDimensions.current

@Composable
fun DevLinkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    CompositionLocalProvider(
        LocalDimensions provides DevLinkDimensions()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}