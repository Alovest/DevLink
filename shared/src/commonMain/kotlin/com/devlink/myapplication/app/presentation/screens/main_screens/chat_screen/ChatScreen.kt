package com.devlink.myapplication.app.presentation.screens.main_screens.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ChatScreen(){
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        Text("CHAT", fontSize = 40.sp)
    }
}

@Composable
@Preview
fun ShowChatScreen(){
    ChatScreen()
}