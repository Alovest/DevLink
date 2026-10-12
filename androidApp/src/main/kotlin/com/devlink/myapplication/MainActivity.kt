package com.devlink.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devlink.myapplication.app.presentation.navigation.navgraph.MainNavigation
import com.devlink.myapplication.app.presentation.ui.theme.DevLinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            DevLinkTheme() {
               MainNavigation()
            }
        }
    }
}

