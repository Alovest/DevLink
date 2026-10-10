package com.devlink.myapplication

import androidx.compose.ui.window.ComposeUIViewController
import com.devlink.myapplication.app.presentation.navigation.navgraph.MainNavigation
import com.devlink.myapplication.app.presentation.ui.theme.DevLinkTheme

fun MainViewController() = ComposeUIViewController { DevLinkTheme { MainNavigation() } }