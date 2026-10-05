package com.devlink.myapplication.app.presentation.uiState.messages

sealed class MessageState {
    data object Idle: MessageState()
    data object Success: MessageState()
    data object Loading: MessageState()
    data class Error(val msgError: String): MessageState()
}