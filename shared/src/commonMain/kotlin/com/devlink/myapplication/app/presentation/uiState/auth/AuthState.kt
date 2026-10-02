package com.devlink.myapplication.app.presentation.uiState.auth

sealed class AuthState {
    data object Idle: AuthState()
    data object Loading: AuthState()
    data class Error(val msgError: String): AuthState()
    data object Success: AuthState()
}