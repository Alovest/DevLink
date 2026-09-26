package com.devlink.myapplication.app.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfBackgroundButtonDarkTheme
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfBackgroundButtonLightTheme
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfBorderContainerLightTheme
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfBorderOfContainerDarkTheme
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfBottomNavigation
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfButton
import com.devlink.myapplication.app.presentation.ui.colors.ColorOfContainerDarkTheme
import com.devlink.myapplication.app.presentation.ui.colors.DarkBackground
import com.devlink.myapplication.app.presentation.ui.colors.DarkThemeText
import com.devlink.myapplication.app.presentation.ui.colors.GreyDarkThemeText
import com.devlink.myapplication.app.presentation.ui.colors.GreyLightThemeText
import com.devlink.myapplication.app.presentation.ui.colors.LightBackground
import com.devlink.myapplication.app.presentation.ui.colors.LightThemeText
import com.devlink.myapplication.app.presentation.ui.dimens.DevLinkDimensions
import com.devlink.myapplication.app.presentation.ui.dimens.LocalDimensions

private val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    onBackground = DarkThemeText,
    onSurface = GreyDarkThemeText,
    onSecondaryContainer = ColorOfBorderOfContainerDarkTheme,
    primary = ColorOfButton,
    onPrimary = ColorOfBackgroundButtonDarkTheme,
    onPrimaryContainer = ColorOfBottomNavigation,
    primaryContainer = ColorOfContainerDarkTheme
)

private val LightColorScheme = lightColorScheme(
    background = LightBackground,
    onBackground = LightThemeText,
    onSurface = GreyLightThemeText,
    onSecondaryContainer = ColorOfBorderContainerLightTheme,
    primary = ColorOfButton,
    onPrimary = ColorOfBackgroundButtonLightTheme,
    onPrimaryContainer = ColorOfBottomNavigation
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