package com.devlink.myapplication.app.presentation.uiState

sealed class AuthState {
    object Idle: AuthState()
    object Loading: AuthState()
    data class Error(val msgError: String): AuthState()
    object Success: AuthState()
}