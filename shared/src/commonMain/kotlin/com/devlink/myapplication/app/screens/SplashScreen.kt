package com.devlink.myapplication.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.compose_multiplatform
import devlink.shared.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(){
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center, ){
                Image(
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = "Logo"
                )
            }
        }
    }
}

@Composable
@Preview
fun ShowContent(){
    SplashScreen()
}